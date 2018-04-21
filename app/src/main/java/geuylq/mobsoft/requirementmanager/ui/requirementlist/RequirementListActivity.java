package geuylq.mobsoft.requirementmanager.ui.requirementlist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import geuylq.mobsoft.requirementmanager.R;

public class RequirementListActivity extends AppCompatActivity implements RequirementListScreen {

    @Inject
    RequirementListPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
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
}
