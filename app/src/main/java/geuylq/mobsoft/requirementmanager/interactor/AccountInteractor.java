package geuylq.mobsoft.requirementmanager.interactor;

import javax.inject.Inject;

import geuylq.mobsoft.requirementmanager.MobSoftApplication;
import geuylq.mobsoft.requirementmanager.repository.Repository;

public class AccountInteractor {

    @Inject
    Repository repository;

    public AccountInteractor() {
        //MobSoftApplication.injector.inject(this);
    }

    public void login(String username, String password) {

    }
}
