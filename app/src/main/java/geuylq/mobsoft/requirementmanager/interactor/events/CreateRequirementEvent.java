package geuylq.mobsoft.requirementmanager.interactor.events;

public class CreateRequirementEvent {
    private Throwable throwable;

    public CreateRequirementEvent(Throwable throwable) {
        this.throwable = throwable;
    }

    public CreateRequirementEvent() {

    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
