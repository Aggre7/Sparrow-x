//package buildingblocks.mediator.behaviors;
//
//import buildingblocks.mediator.abstractions.requests.IPipelineBehavior;
//import buildingblocks.mediator.abstractions.requests.IRequest;
//import buildingblocks.mediator.abstractions.requests.RequestHandlerDelegate;
//import io.opentelemetry.api.trace.Span;
//import io.opentelemetry.api.trace.SpanKind;
//import io.opentelemetry.api.trace.Tracer;
//import io.opentelemetry.context.Scope;
//
//public class TracingPipelineBehavior<TRequest extends IRequest<TResponse>, TResponse>
//        implements IPipelineBehavior<TRequest, TResponse> {
//
//    private final Tracer tracer;
//
//    public TracingPipelineBehavior(Tracer tracer) {
//        this.tracer = tracer;
//    }
//
//    @Override
//    public TResponse handle(TRequest request, RequestHandlerDelegate<TResponse> next) {
//        Span span = tracer.spanBuilder(request.getClass().getSimpleName())
//                .setSpanKind(SpanKind.INTERNAL)
//                .startSpan();
//        try (Scope scope = span.makeCurrent()) {
//            span.setAttribute("request.type", request.getClass().getSimpleName());
//            span.setAttribute("user.id", getUserIdFromSecurityContext());
//            span.setAttribute("command.name", request.getClass().getSimpleName());
//
//            return next.handle();
//        } catch (Exception ex) {
//            span.recordException(ex);
//            throw ex;
//        } finally {
//            span.end();
//        }
//    }
//}
