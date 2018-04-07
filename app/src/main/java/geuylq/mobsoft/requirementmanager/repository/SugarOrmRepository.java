package geuylq.mobsoft.requirementmanager.repository;

import android.content.Context;

import java.util.List;

import geuylq.mobsoft.requirementmanager.model.Requirement;

public class SugarOrmRepository implements Repository {
    @Override
    public void open(Context context) {

    }

    @Override
    public void close() {

    }

    @Override
    public Requirement getRequirement(int id) {
        return null;
    }

    @Override
    public List<Requirement> getRequirements() {
        return null;
    }

    @Override
    public void createRequirement(Requirement requirement) {

    }

    @Override
    public void updateRequirement(List<Requirement> requirements) {

    }

    @Override
    public void removeRequirement(Requirement requirement) {

    }
}
