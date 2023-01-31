package info.pragmaticdeveloper.designpattern.behavioral.chainofresponsibility.supportsystem;

public class ServiceRequest {
    private ServiceLevel type;
    private String conclusion = null;

    public ServiceRequest(ServiceLevel type, String conclusion) {
        this.type = type;
        this.conclusion = conclusion;
    }

    public ServiceLevel getType() {
        return type;
    }

    public String getConclusion() {
        return conclusion;
    }
}
