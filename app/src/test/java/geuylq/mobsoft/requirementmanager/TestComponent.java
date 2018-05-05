package geuylq.mobsoft.requirementmanager;

import javax.inject.Singleton;

import dagger.Component;
import geuylq.mobsoft.requirementmanager.interactor.InteractorModule;
import geuylq.mobsoft.requirementmanager.mock.MockNetworkModule;

@Singleton
@Component(modules = {MockNetworkModule.class, TestModule.class, InteractorModule.class, TestRepositoryModule.class})
public interface TestComponent extends MobSoftApplicationComponent {
}
