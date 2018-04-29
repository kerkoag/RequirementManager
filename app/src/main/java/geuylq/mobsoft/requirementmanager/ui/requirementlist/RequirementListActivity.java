package geuylq.mobsoft.requirementmanager.ui.requirementlist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import javax.inject.Inject;

import geuylq.mobsoft.requirementmanager.MobSoftApplication;
import geuylq.mobsoft.requirementmanager.R;
import geuylq.mobsoft.requirementmanager.model.Requirement;
import geuylq.mobsoft.requirementmanager.ui.requirementdetails.RequirementAdapter;
import geuylq.mobsoft.requirementmanager.ui.requirementdetails.RequirementDetailsActivity;
import geuylq.mobsoft.requirementmanager.ui.requirementdetails.RequirementDetailsPresenter;

public class RequirementListActivity extends AppCompatActivity implements RequirementListScreen {

    private RequirementAdapter adapter;

    @Inject
    RequirementListPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ListView list = (ListView) findViewById(R.id.requirements_list);
        adapter = new RequirementAdapter(this, 0, new ArrayList<Requirement>(Arrays.asList((new Requirement()))));
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Requirement f = (Requirement) parent.getItemAtPosition(position);
                navigateToRequirementDetails(/*f.getId()*/);
            }
        });

        MobSoftApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.attachScreen(this);
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

    public void navigateToRequirementDetails(){
        Intent i = new Intent(this, RequirementDetailsActivity.class);
        //i.putExtra("id", id);
        startActivity(i);
    }
}
