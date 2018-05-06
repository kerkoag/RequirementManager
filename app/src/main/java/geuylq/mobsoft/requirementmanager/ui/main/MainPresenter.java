package geuylq.mobsoft.requirementmanager.ui.main;

import android.util.Log;
import android.widget.Toast;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import static geuylq.mobsoft.requirementmanager.MobSoftApplication.injector;

import de.greenrobot.event.EventBus;
import geuylq.mobsoft.requirementmanager.MobSoftApplication;
import geuylq.mobsoft.requirementmanager.interactor.AccountInteractor;
import geuylq.mobsoft.requirementmanager.interactor.events.LoginEvent;
import geuylq.mobsoft.requirementmanager.ui.BasePresenter;

public class MainPresenter extends BasePresenter<MainScreen> {

    @Inject
    AccountInteractor accountInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    public MainPresenter() {
    }

    @Override
    public void attachScreen(MainScreen screen) {
        super.attachScreen(screen);
        injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        bus.unregister(this);
        super.detachScreen();
    }

    public void login(final String userName, final String password){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                accountInteractor.login(userName, password);
            }
        });
    }

    public void onEventMainThread(LoginEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                Toast.makeText(MobSoftApplication.getAppContext(),"Login failed!",Toast.LENGTH_LONG).show();
            }
        }else if (event.getResult() == false){
            Toast.makeText(MobSoftApplication.getAppContext(),"Login failed!",Toast.LENGTH_LONG).show();
        } else {
            if (screen != null) {
                screen.navigateToRequirements();
            }
        }
    }
}
