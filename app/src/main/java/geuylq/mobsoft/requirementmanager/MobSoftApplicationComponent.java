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
import geuylq.mobsoft.requirementmanager.ui.main.MainPresenter;
import geuylq.mobsoft.requirementmanager.ui.requirementdetails.RequirementDetailsActivity;
import geuylq.mobsoft.requirementmanager.ui.requirementdetails.RequirementDetailsPresenter;
import geuylq.mobsoft.requirementmanager.ui.requirementlist.RequirementListActivity;
import geuylq.mobsoft.requirementmanager.ui.requirementlist.RequirementListPresenter;
import geuylq.mobsoft.requirementmanager.ui.synchronization.SynchronizationActivity;
import geuylq.mobsoft.requirementmanager.ui.synchronization.SynchronizationPresenter;

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

    void inject(MainPresenter presenter);
    void inject(RequirementListPresenter presenter);
    void inject(RequirementDetailsPresenter presenter);
    void inject(SynchronizationPresenter presenter);
}
