package buildingblocks.mediator.behaviors;

import buildingblocks.mediator.abstractions.requests.IPipelineBehavior;
import buildingblocks.mediator.abstractions.requests.IRequest;
import buildingblocks.mediator.abstractions.requests.RequestHandlerDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuditPipelineBehavior<TRequest extends IRequest<TResponse>, TResponse>
        implements IPipelineBehavior<TRequest, TResponse> {

    private static final Logger logger = LoggerFactory.getLogger(AuditPipelineBehavior.class);

    @Override
    public TResponse handle(TRequest request, RequestHandlerDelegate<TResponse> next) {
        String requestType = request.getClass().getSimpleName();
        logger.info("[AUDIT] Handling request: {}", requestType);
        TResponse response = next.handle();
        logger.info("[AUDIT] Completed request: {}", requestType);
        return response;
    }
}
