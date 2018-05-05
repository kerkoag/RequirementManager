package geuylq.mobsoft.requirementmanager;

import android.content.Context;

import java.util.concurrent.Executor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.greenrobot.event.EventBus;
import geuylq.mobsoft.requirementmanager.ui.main.MainPresenter;
import geuylq.mobsoft.requirementmanager.ui.requirementdetails.RequirementDetailsPresenter;
import geuylq.mobsoft.requirementmanager.ui.requirementlist.RequirementListPresenter;
import geuylq.mobsoft.requirementmanager.ui.synchronization.SynchronizationPresenter;

@Module
public class TestModule {
    private final  geuylq.mobsoft.requirementmanager.ui.UIModule UIModule;

    public TestModule(Context context) {
        this.UIModule = new  geuylq.mobsoft.requirementmanager.ui.UIModule(context);
    }

    @Provides
    public Context provideContext() {
        return UIModule.provideContext();
    }


    @Provides
    public MainPresenter provideOverviewPresenter() {
        return UIModule.provideMainPresenter();
    }

    @Provides
    public RequirementListPresenter provideMessagePresenter() {
        return UIModule.provideRequirementListPresenter();
    }

    @Provides
    public RequirementDetailsPresenter provideDetailsPresenter() {
        return UIModule.provideRequirementDetailsPresenter();
    }

    @Provides
    public SynchronizationPresenter provideSynchronizationPresenter() {
        return UIModule.provideSynchronizationPresenter();
    }

    @Provides
    @Singleton
    public EventBus provideEventBus() {
        return EventBus.getDefault();
    }

    @Provides
    @Singleton
    public Executor provideNetworkExecutor() {
        return new UIExecutor();
    }
}
