package geuylq.mobsoft.requirementmanager.ui.requirementlist;

import android.util.Log;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import geuylq.mobsoft.requirementmanager.interactor.RequirementInteractor;
import geuylq.mobsoft.requirementmanager.interactor.events.GetRequirementsEvent;
import geuylq.mobsoft.requirementmanager.model.Requirement;
import geuylq.mobsoft.requirementmanager.ui.BasePresenter;

import static geuylq.mobsoft.requirementmanager.MobSoftApplication.injector;

public class RequirementListPresenter extends BasePresenter<RequirementListScreen> {

    @Inject
    RequirementInteractor requirementInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    public RequirementListPresenter() {
    }

    @Override
    public void attachScreen(RequirementListScreen screen) {
        super.attachScreen(screen);
        injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        bus.unregister(this);
        super.detachScreen();
    }

    public void getRequirementsList(){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                requirementInteractor.getRequirements();
            }
        });
    }

    public void onEventMainThread(GetRequirementsEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                Log.e("Networking", "Error reading plants", event.getThrowable());
            }
        } else {
            if (screen != null) {
                screen.showList(event.getRequirementList());
            }
        }
    }
}
