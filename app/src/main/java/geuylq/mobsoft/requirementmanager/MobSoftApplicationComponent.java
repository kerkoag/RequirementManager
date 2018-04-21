package geuylq.mobsoft.requirementmanager;

import javax.inject.Singleton;

import dagger.Component;
import geuylq.mobsoft.requirementmanager.interactor.AccountInteractor;
import geuylq.mobsoft.requirementmanager.interactor.InteractorModule;
import geuylq.mobsoft.requirementmanager.interactor.RequirementInteractor;
import geuylq.mobsoft.requirementmanager.network.NetworkModule;
import geuylq.mobsoft.requirementmanager.repository.RepositoryModule;
import geuylq.mobsoft.requirementmanager.ui.UIModule;
import geuylq.mobsoft.requirementmanager.ui.main.MainActivity;
import geuylq.mobsoft.requirementmanager.ui.requirementdetails.RequirementDetailsActivity;
import geuylq.mobsoft.requirementmanager.ui.requirementlist.RequirementListActivity;
import geuylq.mobsoft.requirementmanager.ui.synchronization.SynchronizationActivity;

@Singleton
@Component(modules = {UIModule.class, RepositoryModule.class, InteractorModule.class, NetworkModule.class})
public interface MobSoftApplicationComponent {
    void inject(MobSoftApplication mobSoftApplication);

    void inject(SynchronizationActivity synchronizationActivity);
    void inject(RequirementDetailsActivity requirementDetailsActivity);
    void inject(RequirementListActivity requirementListActivity);
    void inject(MainActivity mainActivity);

    void inject(AccountInteractor interactor);
    void inject(RequirementInteractor requirementInteractor);
}
