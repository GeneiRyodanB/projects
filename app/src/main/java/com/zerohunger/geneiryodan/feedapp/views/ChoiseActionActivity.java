package com.zerohunger.geneiryodan.feedapp.views;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChoiseActionActivity extends AppCompatActivity {

    Button feedActButton;
    Button feedBikeButton;
    Intent intent;
    Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choise_action);
        getSupportActionBar().hide();

        activity = this;

        feedActButton = findViewById(R.id.feedActButton);
        feedBikeButton = findViewById(R.id.feedBikeButton);

        feedActButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(activity, NewActionFeedActActivity.class);
                startActivity(intent);
            }
        });

        feedBikeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(activity, NewActionFeedBikeActivity.class);
                startActivity(intent);
            }
        });
    }
}
