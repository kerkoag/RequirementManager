package geuylq.mobsoft.requirementmanager.ui.main;

import geuylq.mobsoft.requirementmanager.ui.BasePresenter;

public class MainPresenter extends BasePresenter<MainScreen> {

    public MainPresenter() {
    }

    @Override
    public void attachScreen(MainScreen screen) {
        super.attachScreen(screen);
        //injector.inject(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    public void login(final String userName, final String password){

    }
}
