package geuylq.mobsoft.requirementmanager.interactor.events;

public class DeleteRequirementEvent {
    private Throwable throwable;

    public DeleteRequirementEvent(Throwable throwable) {
        this.throwable = throwable;
    }

    public DeleteRequirementEvent() {

    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
