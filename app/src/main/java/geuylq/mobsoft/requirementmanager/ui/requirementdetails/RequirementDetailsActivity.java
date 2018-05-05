package geuylq.mobsoft.requirementmanager.ui.requirementdetails;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import javax.inject.Inject;

import geuylq.mobsoft.requirementmanager.MobSoftApplication;
import geuylq.mobsoft.requirementmanager.R;
import geuylq.mobsoft.requirementmanager.model.Requirement;
import geuylq.mobsoft.requirementmanager.ui.requirementlist.RequirementListActivity;

public class RequirementDetailsActivity extends AppCompatActivity implements RequirementDetailsScreen {

    @Inject
    RequirementDetailsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Button deleteButton =  findViewById(R.id.deleteRequirementButton);

        long id = getIntent().getLongExtra("id", 0L);

        if(id == 0){
            deleteButton.setVisibility(View.INVISIBLE);
        }
        else{
            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = getIntent();
                    Long requirementId = intent.getLongExtra("id", 0L);
                    Log.w("ID:", requirementId.toString());
                    presenter.deleteRequirement(requirementId.intValue());
                }
            });
        }

        Button saveButton =  findViewById(R.id.saveRequirementButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Requirement requirement = new Requirement();

                requirement.setTitle(((EditText)findViewById(R.id.title)).getText().toString());
                requirement.setState(((EditText)findViewById(R.id.state)).getText().toString());
                requirement.setPriority(Integer.parseInt(((EditText) findViewById(R.id.priority)).getText().toString()));
                requirement.setAssignedTo(((EditText)findViewById(R.id.assingto)).getText().toString());
                //requirement.setRecordedDate(new Date(((EditText)findViewById(R.id.recorded)).getText().toString());
                requirement.setDescription(((EditText)findViewById(R.id.description)).getText().toString());


                long id = getIntent().getLongExtra("id", 0L);

                if(id > 0){
                    requirement.setId(id);
                    presenter.updateRequirement(requirement);
                }
                else{
                    presenter.createRequirement(requirement);
                }


            }
        });

        MobSoftApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.attachScreen(this);

        Intent intent = getIntent();
        Long requirementId = intent.getLongExtra("id", 0L);

        presenter.getRequirement(requirementId.intValue());
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.detachScreen();
    }

    @Override
    protected void onResume(){
        super.onResume();
    }

    @Override
    public void showDetails(Requirement requirement) {
        ((EditText)findViewById(R.id.title)).setText(requirement.getTitle());
        ((EditText)findViewById(R.id.state)).setText(requirement.getState());
        ((EditText)findViewById(R.id.priority)).setText(requirement.getPriority().toString());
        //((EditText)findViewById(R.id.recorded)).setText(requirement.getRecordedDate().toString());
        ((EditText)findViewById(R.id.assingto)).setText(requirement.getAssignedTo());
        ((EditText)findViewById(R.id.description)).setText(requirement.getDescription());
    }

    public void navigateToRequirementList(){
        super.onBackPressed();
    }
}
