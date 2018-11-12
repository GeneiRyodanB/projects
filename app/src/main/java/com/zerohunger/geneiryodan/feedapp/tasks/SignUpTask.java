package com.zerohunger.geneiryodan.feedapp.tasks;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;

import com.zerohunger.geneiryodan.feedapp.models.users.User;
import com.zerohunger.geneiryodan.feedapp.services.UserService;
import com.zerohunger.geneiryodan.feedapp.views.SignUpResultActivity;

import java.util.HashMap;
import java.util.Map;

import static com.zerohunger.geneiryodan.feedapp.constants.MessageConstant.MESSAGE;
import static com.zerohunger.geneiryodan.feedapp.constants.MessageConstant.NEW_USER;

public class SignUpTask extends AsyncTask<Void, Void, Map>{

    private Activity activity;
    private User user;
    private Intent intentSignUpResult;

    public SignUpTask(Activity activity, User user) {
        this.activity = activity;
        this.user = user;
        intentSignUpResult = new Intent(activity, SignUpResultActivity.class);
    }

    @Override
    protected Map doInBackground(Void... voids) {
        Map<String, String> loginInfo = new UserService(user, activity).signUp();
        return loginInfo;
    }

    @Override
    protected void onPostExecute(Map result) {
        if(result.get(MESSAGE).equals(NEW_USER)){
            intentSignUpResult.putExtra("tel", user.getTel());
            intentSignUpResult.putExtra("password", user.getPassword());
        }
        activity.startActivity(intentSignUpResult);
    }
}
