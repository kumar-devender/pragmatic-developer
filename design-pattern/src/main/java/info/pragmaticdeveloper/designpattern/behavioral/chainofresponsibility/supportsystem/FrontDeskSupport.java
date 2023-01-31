package info.pragmaticdeveloper.designpattern.behavioral.chainofresponsibility.supportsystem;

public class FrontDeskSupport implements SupportServiceable {
    private final SupportServiceable nextHandler;
    private final ServiceLevel SERVICE_SUPPORT_TYPE = ServiceLevel.LEVEL_ONE;

    public FrontDeskSupport(SupportServiceable handler) {
        this.nextHandler = handler;
    }

    @Override
    public void handleRequest(ServiceRequest request) {
        if (request.getType() == SERVICE_SUPPORT_TYPE) {
            System.out.printf("Handling request of type %s \n", SERVICE_SUPPORT_TYPE.name());
            return;
        }
        if (nextHandler != null) {
            System.out.printf("We are forwarding your request to %s \n", nextHandler.getServiceSupportType().name());
            nextHandler.handleRequest(request);
        }
    }

    @Override
    public ServiceLevel getServiceSupportType() {
        return SERVICE_SUPPORT_TYPE;
    }
}
