package geuylq.mobsoft.requirementmanager.interactor;

import javax.inject.Inject;

import geuylq.mobsoft.requirementmanager.MobSoftApplication;
import geuylq.mobsoft.requirementmanager.repository.Repository;

public class RequirementInteractor {
    @Inject
    Repository repository;

    public RequirementInteractor() {
        //MobSoftApplication.injector.inject(this);
    }
}
