package com.zerohunger.geneiryodan.feedapp.views;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.zerohunger.geneiryodan.feedapp.models.users.User;
import com.zerohunger.geneiryodan.feedapp.services.UserService;
import com.zerohunger.geneiryodan.feedapp.tasks.SignUpTask;

public class SignUpActivity extends AppCompatActivity {

    private ImageButton signUpButton;
    private Activity activity;
    private EditText nomSignUpEditText;
    private EditText prenomSignUpEditText;
    private Spinner roleSpinner;
    private EditText emailSignUpEditText;
    private EditText numSignUpEditText;
    private Spinner villeSignUpSpinner;
    private EditText passSignUpEditText;
    private EditText repassSignUpEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        //Hide the title bar
        getSupportActionBar().hide();

        //Initialize GUI Component
        signUpButton = findViewById(R.id.signUpButton);
        nomSignUpEditText = findViewById(R.id.nomSignUpEditText);
        prenomSignUpEditText = findViewById(R.id.prenomSignUpEditText);
        roleSpinner = findViewById(R.id.roleSpinner);
        emailSignUpEditText = findViewById(R.id.emailSignUpEditText);
        numSignUpEditText = findViewById(R.id.numSignUpEditText);
        villeSignUpSpinner = findViewById(R.id.villeSignUpSpinner);
        passSignUpEditText = findViewById(R.id.passSignUpEditText);
        repassSignUpEditText = findViewById(R.id.repassSignUpEditText);
        activity = this;

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nom = nomSignUpEditText.getText().toString();
                String prenom = prenomSignUpEditText.getText().toString();
                String role = roleSpinner.getSelectedItem().toString();
                String email = emailSignUpEditText.getText().toString();
                String numTel = numSignUpEditText.getText().toString();
                String ville = villeSignUpSpinner.getSelectedItem().toString();
                String pass = passSignUpEditText.getText().toString();
                String repass = repassSignUpEditText.getText().toString();
                if(pass.equals(repass)){
                    User newUser = User.buildUser(nom, prenom, email, numTel, ville, pass, role);
                    new SignUpTask(activity, newUser).execute();
                }
                Toast.makeText(activity, "Connection failed", Toast.LENGTH_LONG);

            }
        });
    }
}
