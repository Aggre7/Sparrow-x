package buildingblocks.mediator.behaviors;


import buildingblocks.mediator.abstractions.requests.IPipelineBehavior;
import buildingblocks.mediator.abstractions.requests.IRequest;
import buildingblocks.mediator.abstractions.requests.RequestHandlerDelegate;
import io.micrometer.core.instrument.MeterRegistry;

public class BusinessMetricsPipelineBehavior<TRequest extends IRequest<TResponse>, TResponse>
        implements IPipelineBehavior<TRequest, TResponse> {

    private final MeterRegistry meterRegistry;

    public BusinessMetricsPipelineBehavior(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    @Override
    public TResponse handle(TRequest request, RequestHandlerDelegate<TResponse> next) {
        TResponse response = next.handle();

        // Custom business logic tagging (e.g., number of bookings)
//        if (request instanceof CreateUserCommand) {
//            meterRegistry.counter("business.bookings.created").increment();
//        }

        return response;
    }
}
