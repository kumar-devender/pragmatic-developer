package info.pragmaticdeveloper.designpattern.behavioral.chainofresponsibility.supportsystem;

import info.pragmaticdeveloper.designpattern.behavioral.chainofresponsibility.supportsystem.config.SupportConfig;

public class ServiceSupportTest {
    public static void main(String[] args) {
        ServiceRequest serviceRequest = new ServiceRequest(ServiceLevel.LEVEL_FOUR, "Invalid address in bill");
        SupportServiceable supportService = new SupportConfig().supportServiceBean();
        supportService.handleRequest(serviceRequest);
        supportService.handleRequest(new ServiceRequest(ServiceLevel.LEVEL_TWO, "Book my room"));
    }
}
