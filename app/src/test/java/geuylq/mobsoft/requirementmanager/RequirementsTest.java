package geuylq.mobsoft.requirementmanager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.List;

import geuylq.mobsoft.requirementmanager.model.Requirement;
import geuylq.mobsoft.requirementmanager.ui.requirementlist.RequirementListPresenter;
import geuylq.mobsoft.requirementmanager.ui.requirementlist.RequirementListScreen;

import static geuylq.mobsoft.requirementmanager.TestHelper.setTestInjector;
import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricDaggerTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class RequirementsTest {
    private RequirementListPresenter presenter;

    @Before
    public void setup() throws Exception {
        setTestInjector();
        presenter = new RequirementListPresenter();
    }

    @Test
    public void testGetRequirements() {
        RequirementListScreen screen = mock(RequirementListScreen.class);
        presenter.attachScreen(screen);
        presenter.getRequirementsList();

        ArgumentCaptor<ArrayList<Requirement>> requirementsCaptor = ArgumentCaptor.forClass((Class<ArrayList<Requirement>>) (Class) ArrayList.class);
        verify(screen, times(1)).showList(requirementsCaptor.capture());

        List<Requirement> capturedRequirements = requirementsCaptor.getValue();
        assertEquals(Long.valueOf(1L), capturedRequirements.get(0).getId());
        assertEquals(Long.valueOf(2L), capturedRequirements.get(1).getId());
    }
}
