package geuylq.mobsoft.requirementmanager.interactor.events;

public class LoginEvent {
    private int code;
    private Boolean result;
    private Throwable throwable;

    public LoginEvent(){}

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
