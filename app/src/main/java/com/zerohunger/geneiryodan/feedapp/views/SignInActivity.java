package com.zerohunger.geneiryodan.feedapp.views;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.zerohunger.geneiryodan.feedapp.models.users.User;
import com.zerohunger.geneiryodan.feedapp.tasks.LoginHttpTask;

public class SignInActivity extends AppCompatActivity {

    private Activity activity;
    private Intent signUpIntent;
    private TextView signUpTextView;
    private ImageButton signInButton;
    private EditText numSignInEditText;
    private EditText passSignInEditText;
    private Animation myRotation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        //Hide the title bar
        getSupportActionBar().hide();

        activity = this;
        signInButton = findViewById(R.id.signInButton);
        signUpTextView = findViewById(R.id.sinscrireTextView);
        numSignInEditText = findViewById(R.id.numSignInEditText);
        passSignInEditText = findViewById(R.id.passSignInEditText);
        signUpIntent = new Intent(this, SignUpActivity.class);

        myRotation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotator);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User();
                user.setTel(numSignInEditText.getText().toString());
                user.setPassword(passSignInEditText.getText().toString());
                //float deg = signInButton.getRotation() + 1080F;
                //signInButton.animate().rotation(deg).start();
                signInButton.startAnimation(myRotation);
                new LoginHttpTask(activity, user).execute();
                Toast.makeText(activity, "Connection failed", Toast.LENGTH_LONG);
            }
        });

        signUpTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(signUpIntent);
            }
        });
    }
}
