package geuylq.mobsoft.requirementmanager.interactor.events;

import geuylq.mobsoft.requirementmanager.model.Requirement;

public class GetRequirementEvent {
    private Throwable throwable;
    private Requirement requirement;

    public GetRequirementEvent(Throwable throwable, Requirement requirement) {
        this.throwable = throwable;
        this.requirement = requirement;
    }

    public GetRequirementEvent() {

    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    public Requirement getRequirement() {
        return requirement;
    }

    public void setRequirement(Requirement requirement) {
        this.requirement = requirement;
    }
}
