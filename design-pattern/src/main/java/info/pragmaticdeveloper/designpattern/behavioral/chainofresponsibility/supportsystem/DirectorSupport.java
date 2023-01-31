package info.pragmaticdeveloper.designpattern.behavioral.chainofresponsibility.supportsystem;

public class DirectorSupport implements SupportServiceable {
    private final ServiceLevel SERVICE_SUPPORT_TYPE = ServiceLevel.LEVEL_FOUR;

    @Override
    public void handleRequest(ServiceRequest request) {
        if (request.getType() == SERVICE_SUPPORT_TYPE) {
            System.out.printf("Handling request of type %s \n", SERVICE_SUPPORT_TYPE.name());
        }
    }

    @Override
    public ServiceLevel getServiceSupportType() {
        return SERVICE_SUPPORT_TYPE;
    }
}
