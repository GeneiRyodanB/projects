package com.zerohunger.geneiryodan.feedapp.views;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zerohunger.geneiryodan.feedapp.models.users.User;
import com.zerohunger.geneiryodan.feedapp.tasks.LoginHttpTask;

import java.util.Map;

public class SignUpResultActivity extends AppCompatActivity {

    private Button signInButton;
    private Intent intent;
    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_result);
        //Hide the title bar
        getSupportActionBar().hide();

        activity = this;
        signInButton = findViewById(R.id.signInResultButton);
        intent = getIntent();

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tel = intent.getStringExtra("tel");
                String password = intent.getStringExtra("password");
                User user = new User(tel, password);
                new LoginHttpTask(activity, user).execute();

            }
        });
    }
}
