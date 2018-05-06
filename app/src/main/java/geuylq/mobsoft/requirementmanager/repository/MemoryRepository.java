package geuylq.mobsoft.requirementmanager.repository;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import geuylq.mobsoft.requirementmanager.model.Requirement;
import geuylq.mobsoft.requirementmanager.network.model.Account;

public class MemoryRepository implements Repository {

    List<Requirement> requirements;
    List<Account> accounts;

    private static long NEXT_ID = 100;

    @Override
    public void open(Context context) {
        Log.w("Open meghívva", "");

        if(requirements == null){
            requirements = new ArrayList<>();
            Requirement req1 = new Requirement();
            req1.setId((long)1);
            req1.setTitle("Teszt követelmény");
            req1.setAssignedTo("Teszt User");
            req1.setPriority(2);
            req1.setState("Új");
            req1.setStatus("");
            req1.setDescription("Hosszú teszt követelmény leírás");

            Requirement req2 = new Requirement();
            req2.setId((long)2);
            req2.setTitle("Minta követelmény");
            req2.setAssignedTo("Példa Péter");
            req2.setPriority(2);
            req2.setState("Folyamatban");
            req2.setStatus("");
            req2.setDescription("Egy másik leírás");

            requirements.add(req1);
            requirements.add(req2);
        }

        if(accounts == null){
            accounts = new ArrayList<>(Arrays.asList(
                    new Account("admin", "admin")
            ));
        }
    }

    @Override
    public void close() {

    }

    @Override
    public Boolean login(String username, String password) {
        for(Account account : accounts) {
            if(account.getUserName().equals(username) && account.getPassword().equals(password))
                return true;
        }

        return false;
    }

    @Override
    public Requirement getRequirement(int id) {
        for(Requirement requirement : requirements) {
            if(requirement.getId() == id) {
                return requirement;
            }
        }
        return null;
    }

    @Override
    public List<Requirement> getRequirements() {
        return requirements;
    }

    @Override
    public void createRequirement(Requirement requirement) {
        requirement.setId(NEXT_ID++);
        requirements.add(requirement);
    }

    @Override
    public void updateRequirement(Requirement requirement) {
        Requirement old = getRequirement(requirement.getId().intValue());
        old.setTitle(requirement.getTitle());
        old.setStatus(requirement.getStatus());
        old.setState(requirement.getState());
        old.setPriority(requirement.getPriority());
        old.setAssignedTo(requirement.getAssignedTo());
        old.setRecordedDate(requirement.getRecordedDate());
        old.setDescription(requirement.getDescription());
    }

    @Override
    public void removeRequirement(Requirement requirement) {
        requirements.remove(requirement);
    }
}
