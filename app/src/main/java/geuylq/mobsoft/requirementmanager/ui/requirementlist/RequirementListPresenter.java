package geuylq.mobsoft.requirementmanager.ui.requirementlist;

import geuylq.mobsoft.requirementmanager.ui.BasePresenter;

import static geuylq.mobsoft.requirementmanager.MobSoftApplication.injector;

public class RequirementListPresenter extends BasePresenter<RequirementListScreen> {

    public RequirementListPresenter() {
    }

    @Override
    public void attachScreen(RequirementListScreen screen) {
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
