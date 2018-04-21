package geuylq.mobsoft.requirementmanager.interactor.events;

import java.util.List;
import geuylq.mobsoft.requirementmanager.model.Requirement;

public class GetRequirementsEvent {
    private List<Requirement> requirementList;
    private Throwable throwable;


    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    public List<Requirement> getRequirementList() {
        return requirementList;
    }

    public void setRequirementList(List<Requirement> requirementList) {
        this.requirementList = requirementList;
    }
}
