package geuylq.mobsoft.requirementmanager.ui.requirementdetails;

import geuylq.mobsoft.requirementmanager.ui.BasePresenter;

import static geuylq.mobsoft.requirementmanager.MobSoftApplication.injector;

public class RequirementDetailsPresenter extends BasePresenter<RequirementDetailsScreen> {

    public RequirementDetailsPresenter() {
    }

    @Override
    public void attachScreen(RequirementDetailsScreen screen) {
        super.attachScreen(screen);
        injector.inject(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    public void getRequirement(int id){

    }
}
