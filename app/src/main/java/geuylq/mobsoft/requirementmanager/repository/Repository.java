package geuylq.mobsoft.requirementmanager.repository;

import android.content.Context;
import geuylq.mobsoft.requirementmanager.model.Requirement;

import java.util.List;

public interface Repository {
    void open(Context context);

    void close();

    Requirement getRequirement(int id);

    List<Requirement> getRequirements();

    void createRequirement(Requirement requirement);

    void updateRequirement(List<Requirement> requirements);

    void removeRequirement(Requirement requirement);

}
