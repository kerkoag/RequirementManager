package geuylq.mobsoft.requirementmanager.ui.requirementdetails;

import geuylq.mobsoft.requirementmanager.model.Requirement;

public interface RequirementDetailsScreen {
    void showDetails(Requirement requirement);

    void navigateToRequirementList();
}
