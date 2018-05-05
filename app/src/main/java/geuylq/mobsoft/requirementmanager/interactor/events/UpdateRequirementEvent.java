package geuylq.mobsoft.requirementmanager.interactor.events;

public class UpdateRequirementEvent {
    private Throwable throwable;

    public UpdateRequirementEvent(Throwable throwable) {
        this.throwable = throwable;
    }

    public UpdateRequirementEvent() {

    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
