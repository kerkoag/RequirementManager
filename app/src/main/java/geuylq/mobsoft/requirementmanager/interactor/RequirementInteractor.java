package geuylq.mobsoft.requirementmanager.interactor;

import javax.inject.Inject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;
import geuylq.mobsoft.requirementmanager.MobSoftApplication;
import geuylq.mobsoft.requirementmanager.interactor.events.GetRequirementsEvent;
import geuylq.mobsoft.requirementmanager.model.Requirement;
import geuylq.mobsoft.requirementmanager.network.api.RequirementsApi;
import geuylq.mobsoft.requirementmanager.repository.Repository;

public class RequirementInteractor {
    @Inject
    Repository repository;
    @Inject
    EventBus bus;
    @Inject
    RequirementsApi api;

    public RequirementInteractor() {
        MobSoftApplication.injector.inject(this);
        repository.open(null);
    }

    public void getRequirements() {
        GetRequirementsEvent event = new GetRequirementsEvent();

        try {
            List<Requirement> requirementList = repository.getRequirements();
            event.setRequirementList(requirementList);
        } catch (Exception e) {
            event.setThrowable(e);
        } finally {
            bus.post(event);
        }
    }

    public void getRequirementsFromServer() {
        try {
            List<geuylq.mobsoft.requirementmanager.network.model.Requirement> result = api.requirementsGet().execute().body();
            for(geuylq.mobsoft.requirementmanager.network.model.Requirement a : result){
                repository.getRequirements();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void updateRequirements(List<geuylq.mobsoft.requirementmanager.network.model.Requirement> requirements) {
        try {

            ArrayList<geuylq.mobsoft.requirementmanager.network.model.Requirement> apiModel = new ArrayList<>();

            for (geuylq.mobsoft.requirementmanager.network.model.Requirement a : requirements) {
                apiModel.add(a);
            }
            // TODO: Csak egyféle model használata!
            //repository.updateRequirement(requirements);
            //api.requirementsIdPost(1, apiModel.get(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
