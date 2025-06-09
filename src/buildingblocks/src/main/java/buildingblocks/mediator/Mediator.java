package buildingblocks.mediator;

import buildingblocks.mediator.abstractions.IMediator;
import buildingblocks.mediator.abstractions.commands.ICommand;
import buildingblocks.mediator.abstractions.commands.ICommandHandler;
import buildingblocks.mediator.abstractions.notifications.INotification;
import buildingblocks.mediator.abstractions.queries.IQuery;
import buildingblocks.mediator.abstractions.requests.IPipelineBehavior;
import buildingblocks.mediator.abstractions.requests.IRequest;
import buildingblocks.mediator.abstractions.requests.RequestHandlerDelegate;
import buildingblocks.utils.bean.SpringBeanUtils;
import buildingblocks.utils.validation.ValidationUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.core.ResolvableType;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;


class Mediator implements IMediator {
    private final ApplicationContext applicationContext;
    private final ConcurrentHashMap<Class<?>, ICommandHandler<?, ?>> commandHandlerCache = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<Class<?>, List<IPipelineBehavior<?, ?>>> requestPipelineCache =
            new ConcurrentHashMap<>();

    Mediator(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public <TNotification extends INotification> Void publish(TNotification notification) throws Exception {
        return null;
    }

    @Override
    public <TResponse> TResponse send(IRequest<TResponse> request) {
        return null;
    }

    @Override
    public <TResponse> TResponse send(ICommand<TResponse> command) {
        ValidationUtils.notBeNull(command, "command");

        var commandHandler = resolveCommandHandler(command, applicationContext);
        var pipelineBehaviors = resolveRequestPipelineBehaviors(command, applicationContext);

        // Build the handler chain containing actual handler and all registered pipelines
        RequestHandlerDelegate<TResponse> handlerChain = () -> commandHandler.handle(command);
        for (var behavior : pipelineBehaviors) {
            final RequestHandlerDelegate<TResponse> current = handlerChain;
            handlerChain = () -> behavior.handle(command, current);
        }

        return handlerChain.handle();
    }

    @Override
    public <TResponse> TResponse send(IQuery<TResponse> query) {
        return null;
    }

    private <TCommand extends ICommand<TResponse>, TResponse>
    ICommandHandler<TCommand, TResponse> resolveCommandHandler(
            TCommand command, ApplicationContext applicationContext) {
        return (ICommandHandler<TCommand, TResponse>) commandHandlerCache.computeIfAbsent(
                // command hashmap key (Class<?>)
                command.getClass(),
                // try to get our hash map key data in existing dictionary if not exist get it with this lambda
                requestType -> {
                    var responseType = getResponseTypeFromRequest(command);
                    String format = String.format(
                            "Not registered a command handler for type: '%s'",
                            command.getClass().getName());

                    if (responseType == null) {
                        throw new IllegalStateException(format);
                    }

                    ResolvableType resolvableType = ResolvableType.forClassWithGenerics(
                            ICommandHandler.class, command.getClass(), responseType);

                    var beanNames = SpringBeanUtils.resolveBeans(applicationContext, resolvableType);

                    // request-response strategy should have `exactly one` handler and if we can't find a corresponding
                    // handler, we should return an error
                    if (beanNames.length == 0) {
                        throw new IllegalStateException(format);
                    }
                    if (beanNames.length > 1) {
                        throw new IllegalStateException(String.format(
                                "Multiple request handlers registered for type: '%s'",
                                command.getClass().getName()));
                    }

                    // Use applicationContext to retrieve the bean
                    ICommandHandler<?, ?> handler = (ICommandHandler<?, ?>) applicationContext.getBean(beanNames[0]);

                    return handler;
                });
    }

    private <TRequest extends IRequest<TResponse>, TResponse>
    List<IPipelineBehavior<TRequest, TResponse>> resolveRequestPipelineBehaviors(
            TRequest request, ApplicationContext applicationContext) {

        return (List<IPipelineBehavior<TRequest, TResponse>>) (List<?>) requestPipelineCache.computeIfAbsent(
                // request hashmap key (Class<?>)
                request.getClass(),
                // try to get our hash map key data in existing dictionary if not exist get it with this lambda
                requestTypeInput -> {
                    var responseType = getResponseTypeFromRequest(request);
                    if (responseType == null) {
                        // pipelines are optional
                        return Collections.emptyList();
                    }

                    // here because we register our pipelines based on generic TRequest and TResponse we should resolve
                    // IPipelineBehavior with object type for both TRequest and TResponse
                    ResolvableType resolvableType =
                            ResolvableType.forClassWithGenerics(IPipelineBehavior.class, Object.class, Object.class);
                    var beanNames = SpringBeanUtils.resolveBeans(applicationContext, resolvableType);

                    // pipelines are optional
                    if (beanNames.length == 0) {
                        return Collections.emptyList();
                    }

                    List<IPipelineBehavior<?, ?>> behaviors = Stream.of(beanNames)
                            .map(name -> (IPipelineBehavior<?, ?>) applicationContext.getBean(name))
                            .collect(Collectors.toList());

                    // Reverse the order of the pipeline behaviors
                    Collections.reverse(behaviors);

                    return behaviors;
                });
    }


    private <TRequest> Class<?> getResponseTypeFromRequest(TRequest request) {
        // List of interfaces we want to check
        Class<?>[] targetInterfaces = {IRequest.class, IQuery.class, ICommand.class};

        Type[] genericInterfaces = request.getClass().getGenericInterfaces();

        for (Type genericInterface : genericInterfaces) {
            if (genericInterface instanceof ParameterizedType paramType) {
                Type rawType = paramType.getRawType();
                for (Class<?> targetInterface : targetInterfaces) {
                    if (rawType.equals(targetInterface)) {
                        Type responseType = paramType.getActualTypeArguments()[0];
                        return ResolvableType.forType(responseType).resolve();
                    }
                }
            }
        }

        return null;
    }


}
