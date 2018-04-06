package geuylq.mobsoft.requirementmanager;

import javax.inject.Singleton;

import dagger.Component;
import geuylq.mobsoft.requirementmanager.repository.RepositoryModule;

@Singleton
@Component(modules = {RepositoryModule.class})
public interface MobSoftApplicationComponent {
}
