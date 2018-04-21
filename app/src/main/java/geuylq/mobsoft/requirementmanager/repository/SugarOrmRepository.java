package geuylq.mobsoft.requirementmanager.repository;

import android.content.Context;

import com.orm.SugarContext;
import com.orm.SugarRecord;

import java.util.List;

import geuylq.mobsoft.requirementmanager.model.Requirement;

public class SugarOrmRepository implements Repository {
    @Override
    public void open(Context context) {
        SugarContext.init(context);
    }

    @Override
    public void close() {
        SugarContext.terminate();
    }

    @Override
    public Requirement getRequirement(int id) {
        return SugarRecord.findById(Requirement.class,id);
    }

    @Override
    public List<Requirement> getRequirements() {
        return SugarRecord.listAll(Requirement.class);
    }

    @Override
    public void createRequirement(Requirement requirement) {
        SugarRecord.saveInTx(requirement);
    }

    @Override
    public void updateRequirement(List<Requirement> requirements) {
        SugarRecord.saveInTx(requirements);
    }

    @Override
    public void removeRequirement(Requirement requirement) {
        SugarRecord.deleteInTx(requirement);
    }
}
