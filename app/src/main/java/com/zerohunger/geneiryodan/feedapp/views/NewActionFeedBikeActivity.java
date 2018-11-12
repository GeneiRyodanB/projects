package com.zerohunger.geneiryodan.feedapp.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class NewActionFeedBikeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_action_feed_bike);
        getSupportActionBar().hide();
    }
}
