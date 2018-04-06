package geuylq.mobsoft.requirementmanager;

import android.app.Application;

import javax.inject.Inject;

import geuylq.mobsoft.requirementmanager.repository.Repository;
import geuylq.mobsoft.requirementmanager.ui.UIModule;

public class MobSoftApplication extends Application {
    @Inject
    Repository repository;

    public static MobSoftApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();

        //injector = DaggerMobSoftApplicationComponent.builder().uIModule(new UIModule(this)).build();

        //injector.inject(this);
        repository.open(getApplicationContext());
    }
}
