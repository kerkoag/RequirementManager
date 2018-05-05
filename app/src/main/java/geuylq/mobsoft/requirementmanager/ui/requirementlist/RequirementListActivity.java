package geuylq.mobsoft.requirementmanager.ui.requirementlist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableStringBuilder;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import geuylq.mobsoft.requirementmanager.MobSoftApplication;
import geuylq.mobsoft.requirementmanager.R;
import geuylq.mobsoft.requirementmanager.model.Requirement;
import geuylq.mobsoft.requirementmanager.ui.requirementdetails.RequirementDetailsActivity;

public class RequirementListActivity extends AppCompatActivity implements RequirementListScreen {

    private RequirementAdapter adapter;

    @Inject
    RequirementListPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ListView list = (ListView) findViewById(R.id.requirements_list);
        adapter = new RequirementAdapter(this, 0, new ArrayList<Requirement>(Arrays.asList(new Requirement())));
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Requirement f = (Requirement) parent.getItemAtPosition(position);
                navigateToRequirementDetails(f.getId());
            }
        });

        Button createButton =  findViewById(R.id.createButton);
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToRequirementDetails((long)0);
            }
        });

        MobSoftApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.attachScreen(this);

        presenter.getRequirementsList();
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

    public void navigateToRequirementDetails(Long id){
        Intent i = new Intent(this, RequirementDetailsActivity.class);
        i.putExtra("id", id);
        startActivity(i);
    }

    @Override
    public void showList(List<Requirement> requirementList) {
        adapter.clear();
        adapter.addAll(requirementList);
    }
}
