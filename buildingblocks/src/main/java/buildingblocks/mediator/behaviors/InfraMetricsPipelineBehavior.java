package buildingblocks.mediator.behaviors;

import buildingblocks.mediator.abstractions.requests.IPipelineBehavior;
import buildingblocks.mediator.abstractions.requests.IRequest;
import buildingblocks.mediator.abstractions.requests.RequestHandlerDelegate;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;

public class InfraMetricsPipelineBehavior<TRequest extends IRequest<TResponse>, TResponse>
        implements IPipelineBehavior<TRequest, TResponse> {

    private final MeterRegistry meterRegistry;

    public InfraMetricsPipelineBehavior(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    @Override
    public TResponse handle(TRequest request, RequestHandlerDelegate< TResponse> next)  {
        String requestName = request.getClass().getSimpleName();
        Timer.Sample sample = Timer.start(meterRegistry);

        try {
            return next.handle();
        } finally {
            sample.stop(Timer.builder("infra.request.duration")
                    .tag("request", requestName)
                    .register(meterRegistry));
        }
    }
}



