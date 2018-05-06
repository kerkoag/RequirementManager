package geuylq.mobsoft.requirementmanager.interactor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import geuylq.mobsoft.requirementmanager.MobSoftApplication;
import geuylq.mobsoft.requirementmanager.interactor.events.LoginEvent;
import geuylq.mobsoft.requirementmanager.network.api.RequirementsApi;
import geuylq.mobsoft.requirementmanager.network.model.Account;
import geuylq.mobsoft.requirementmanager.repository.Repository;

public class AccountInteractor {

    @Inject
    Repository repository;

    @Inject
    RequirementsApi api;

    @Inject
    EventBus bus;

    public AccountInteractor() {

        MobSoftApplication.injector.inject(this);
    }

    public void login(String username, String password) {
        LoginEvent event = new LoginEvent();
        try {
            Account account = new Account();
            account.setUserName(username);
            account.setPassword(password);

            int responseCode = api.login(account).execute().code();
            event.setResult(responseCode == 200 ? true : false);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }
}
