package geuylq.mobsoft.requirementmanager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import geuylq.mobsoft.requirementmanager.repository.MemoryRepository;
import geuylq.mobsoft.requirementmanager.repository.Repository;

@Module
public class TestRepositoryModule {
    @Singleton
    @Provides
    public Repository provideRepository() {

        return new MemoryRepository();
    }
}
