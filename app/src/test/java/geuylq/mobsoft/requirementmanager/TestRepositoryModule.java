package geuylq.mobsoft.requirementmanager;

import javax.inject.Singleton;

import dagger.Provides;
import geuylq.mobsoft.requirementmanager.repository.MemoryRepository;
import geuylq.mobsoft.requirementmanager.repository.Repository;

public class TestRepositoryModule {
    @Singleton
    @Provides
    public Repository provideRepository() {
        return new MemoryRepository();
    }
}
