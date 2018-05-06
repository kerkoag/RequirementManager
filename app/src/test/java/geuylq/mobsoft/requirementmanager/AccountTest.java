package geuylq.mobsoft.requirementmanager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.annotation.Config;

import geuylq.mobsoft.requirementmanager.ui.main.MainPresenter;
import geuylq.mobsoft.requirementmanager.ui.main.MainScreen;

import static geuylq.mobsoft.requirementmanager.TestHelper.setTestInjector;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricDaggerTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class AccountTest {
    private MainPresenter presenter;

    @Before
    public void setup() throws Exception {
        setTestInjector();
        presenter = new MainPresenter();
    }

    @Test
    public void testLogin() {
        MainScreen screen = mock(MainScreen.class);
        presenter.attachScreen(screen);
        presenter.login("admin","admin");

        verify(screen, times(1)).navigateToRequirements();
    }
}
