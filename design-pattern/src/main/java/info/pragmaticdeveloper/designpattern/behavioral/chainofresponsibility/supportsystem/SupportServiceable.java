package info.pragmaticdeveloper.designpattern.behavioral.chainofresponsibility.supportsystem;

public interface SupportServiceable {
    void handleRequest(ServiceRequest request);
    ServiceLevel getServiceSupportType();
}
