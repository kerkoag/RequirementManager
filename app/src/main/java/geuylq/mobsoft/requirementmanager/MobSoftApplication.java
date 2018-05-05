package geuylq.mobsoft.requirementmanager;

import android.app.Application;
import android.content.Context;

import javax.inject.Inject;

import geuylq.mobsoft.requirementmanager.repository.Repository;
import geuylq.mobsoft.requirementmanager.ui.UIModule;

public class MobSoftApplication extends Application {
    @Inject
    Repository repository;

    public static MobSoftApplicationComponent injector;
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        MobSoftApplication.context= getApplicationContext();
        injector = DaggerMobSoftApplicationComponent.builder().uIModule(new UIModule(this)).build();

        injector.inject(this);
        repository.open(getApplicationContext());
    }

    public static Context getAppContext() {
        return MobSoftApplication.context;
    }

    public void setInjector(MobSoftApplicationComponent appComponent) {
                injector = appComponent;
                injector.inject(this);
                repository.open(getApplicationContext());
    }
}
