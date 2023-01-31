package info.pragmaticdeveloper.designpattern.behavioral.chainofresponsibility.supportsystem.config;

import info.pragmaticdeveloper.designpattern.behavioral.chainofresponsibility.supportsystem.*;

public class SupportConfig {
    public SupportServiceable supportServiceBean() {
        return new SupportService(frontDeskSupportBean());
    }

    private FrontDeskSupport frontDeskSupportBean() {
        return new FrontDeskSupport(supervisorSupportBean());
    }

    private SupervisorSupport supervisorSupportBean() {
        return new SupervisorSupport(managerSupportBean());
    }

    private ManagerSupport managerSupportBean() {
        return new ManagerSupport(directorSupportBean());
    }

    private DirectorSupport directorSupportBean() {
        return new DirectorSupport();
    }
}
