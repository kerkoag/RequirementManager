package geuylq.mobsoft.requirementmanager.ui.requirementdetails;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import geuylq.mobsoft.requirementmanager.R;

public class RequirementDetailsActivity extends AppCompatActivity implements RequirementDetailsScreen {

    @Inject
    RequirementDetailsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
