package geuylq.mobsoft.requirementmanager.ui.synchronization;

import geuylq.mobsoft.requirementmanager.ui.BasePresenter;

import static geuylq.mobsoft.requirementmanager.MobSoftApplication.injector;

public class SynchronizationPresenter extends BasePresenter<SynchronizationScreen> {

    public SynchronizationPresenter() {
    }

    @Override
    public void attachScreen(SynchronizationScreen screen) {
        super.attachScreen(screen);
        injector.inject(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    public void getRequirementsList(){

    }
}
