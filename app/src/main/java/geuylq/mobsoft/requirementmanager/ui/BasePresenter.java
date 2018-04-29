package geuylq.mobsoft.requirementmanager.ui;

public abstract class BasePresenter<S> {
    protected S screen;

    public void attachScreen(S screen) {
        this.screen = screen;
    }

    public void detachScreen() {
        this.screen = null;
    }
}
