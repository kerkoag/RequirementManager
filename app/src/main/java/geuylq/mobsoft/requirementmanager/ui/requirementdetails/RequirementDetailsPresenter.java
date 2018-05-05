package geuylq.mobsoft.requirementmanager.ui.requirementdetails;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import geuylq.mobsoft.requirementmanager.interactor.RequirementInteractor;
import geuylq.mobsoft.requirementmanager.interactor.events.CreateRequirementEvent;
import geuylq.mobsoft.requirementmanager.interactor.events.DeleteRequirementEvent;
import geuylq.mobsoft.requirementmanager.interactor.events.GetRequirementEvent;
import geuylq.mobsoft.requirementmanager.interactor.events.UpdateRequirementEvent;
import geuylq.mobsoft.requirementmanager.model.Requirement;
import geuylq.mobsoft.requirementmanager.ui.BasePresenter;

import static geuylq.mobsoft.requirementmanager.MobSoftApplication.injector;

public class RequirementDetailsPresenter extends BasePresenter<RequirementDetailsScreen> {

    @Inject
    RequirementInteractor requirementInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    public RequirementDetailsPresenter() {
    }

    @Override
    public void attachScreen(RequirementDetailsScreen screen) {
        super.attachScreen(screen);
        injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        bus.unregister(this);
        super.detachScreen();
    }

    public void getRequirement(final int id){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                requirementInteractor.getRequirement((long)id);
            }
        });
    }

    public void createRequirement(final Requirement requirement){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                requirementInteractor.createRequirement(requirement);
            }
        });
    }

    public void updateRequirement(final Requirement requirement){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                requirementInteractor.updateRequirement(requirement);
            }
        });
    }

    public void deleteRequirement(final int id){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                requirementInteractor.deleteRequirement((long)id);
            }
        });
    }

    public void onEventMainThread(GetRequirementEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showDetails(null);
            }
        } else {
            if (screen != null) {
                screen.showDetails(event.getRequirement());
            }
        }
    }

    public void onEventMainThread(CreateRequirementEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.navigateToRequirementList();
            }
        } else {
            if (screen != null) {
                screen.navigateToRequirementList();
            }
        }
    }

    public void onEventMainThread(UpdateRequirementEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.navigateToRequirementList();
            }
        } else {
            if (screen != null) {
                screen.navigateToRequirementList();
            }
        }
    }

    public void onEventMainThread(DeleteRequirementEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.navigateToRequirementList();
            }
        } else {
            if (screen != null) {
                screen.navigateToRequirementList();
            }
        }
    }
}
