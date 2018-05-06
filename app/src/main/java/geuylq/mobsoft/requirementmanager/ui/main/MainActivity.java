package geuylq.mobsoft.requirementmanager.ui.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import javax.inject.Inject;

import geuylq.mobsoft.requirementmanager.MobSoftApplication;
import geuylq.mobsoft.requirementmanager.R;
import geuylq.mobsoft.requirementmanager.ui.requirementlist.RequirementListActivity;

public class MainActivity extends AppCompatActivity implements MainScreen {

    @Inject
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button loginButton =  findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = ((EditText)findViewById(R.id.loginName)).getText().toString();
                String password = ((EditText)findViewById(R.id.loginPassword)).getText().toString();
                mainPresenter.login(username, password);
            }
        });

        MobSoftApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainPresenter.detachScreen();
    }

    @Override
    protected void onResume(){
        super.onResume();
    }

    public void navigateToRequirements() {
        Intent i = new Intent(this, RequirementListActivity.class);
        startActivity(i);
    }
}
