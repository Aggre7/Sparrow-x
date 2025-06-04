package buildingblocks.mediator;

import buildingblocks.mediator.abstractions.IMediator;
import buildingblocks.mediator.abstractions.commands.ICommand;
import buildingblocks.mediator.abstractions.notifications.INotification;
import buildingblocks.mediator.abstractions.queries.IQuery;
import buildingblocks.mediator.abstractions.requests.IRequest;
import org.springframework.context.ApplicationContext;

class Mediator implements IMediator {
    private final ApplicationContext applicationContext;

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
        return null;
    }

    @Override
    public <TResponse> TResponse send(IQuery<TResponse> query) {
        return null;
    }
}
