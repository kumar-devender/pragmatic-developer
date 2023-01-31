package info.pragmaticdeveloper.designpattern.behavioral.chainofresponsibility.supportsystem;

public class SupportService implements SupportServiceable {
    private final SupportServiceable nextHandler;

    public SupportService(SupportServiceable handler) {
        this.nextHandler = handler;
    }

    @Override
    public void handleRequest(ServiceRequest request) {
        System.out.printf("We are forwarding your request to %s \n", nextHandler.getServiceSupportType().name());
        nextHandler.handleRequest(request);
    }

    @Override
    public ServiceLevel getServiceSupportType() {
        return null;
    }
}
