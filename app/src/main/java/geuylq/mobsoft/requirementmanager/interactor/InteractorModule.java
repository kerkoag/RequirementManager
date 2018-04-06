package geuylq.mobsoft.requirementmanager.interactor;

import dagger.Module;
import dagger.Provides;

@Module
public class InteractorModule {
    @Provides
    public AccountInteractor provideAccount() {
        return new AccountInteractor();
    }

    @Provides
    public RequirementInteractor provideRequirement() {
        return new RequirementInteractor();
    }
}
