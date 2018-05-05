package geuylq.mobsoft.requirementmanager.ui;

import android.content.Context;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.greenrobot.event.EventBus;
import geuylq.mobsoft.requirementmanager.ui.main.MainPresenter;
import geuylq.mobsoft.requirementmanager.ui.requirementdetails.RequirementDetailsPresenter;
import geuylq.mobsoft.requirementmanager.ui.requirementlist.RequirementListPresenter;
import geuylq.mobsoft.requirementmanager.ui.synchronization.SynchronizationPresenter;

@Module
public class UIModule {

    private Context context;

    public UIModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    public MainPresenter provideMainPresenter() {
        return new MainPresenter();
    }

    @Provides
    @Singleton
    public RequirementListPresenter provideRequirementListPresenter() {
        return new RequirementListPresenter();
    }

    @Provides
    @Singleton
    public RequirementDetailsPresenter provideRequirementDetailsPresenter() {
        return new RequirementDetailsPresenter();
    }

    @Provides
    @Singleton
    public SynchronizationPresenter provideSynchronizationPresenter() {
        return new SynchronizationPresenter();
    }

    @Provides
    @Singleton
    public EventBus provideEventBus() {
        return EventBus.getDefault();
    }

    @Provides
    @Singleton
    public Executor provideExecutor() {
        return Executors.newFixedThreadPool(1);
    }

}
