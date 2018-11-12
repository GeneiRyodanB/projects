package com.zerohunger.geneiryodan.feedapp.tasks;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.zerohunger.geneiryodan.feedapp.models.actualites.FilActualite;
import com.zerohunger.geneiryodan.feedapp.models.users.User;
import com.zerohunger.geneiryodan.feedapp.services.ConfigurationService;
import com.zerohunger.geneiryodan.feedapp.services.UserService;
import com.zerohunger.geneiryodan.feedapp.views.FilActualiteActivity;

import java.util.Map;

import static com.zerohunger.geneiryodan.feedapp.constants.MessageConstant.CONNECTED;
import static com.zerohunger.geneiryodan.feedapp.constants.MessageConstant.ERROR_OCCURRED;
import static com.zerohunger.geneiryodan.feedapp.constants.MessageConstant.MESSAGE;
import static com.zerohunger.geneiryodan.feedapp.constants.MessageConstant.TOKEN_GENERATED;
import static com.zerohunger.geneiryodan.feedapp.constants.MessageConstant.TELNUMBER;

public class LoginHttpTask extends AsyncTask<Void, Void, Map> {

    private Activity activity;
    private User user;
    private Intent loginResultIntent;


    public LoginHttpTask(Activity activity, User user) {
        this.activity = activity;
        this.user = user;

    }

    @Override
    protected Map doInBackground(Void... voids) {
            Map<String, String> loginInfo = new UserService(user, activity).getJWT();
            if(loginInfo.get(MESSAGE).equals(TOKEN_GENERATED)){
                loginInfo.put(TELNUMBER, user.getTel());
                ConfigurationService.storeJWT(activity, loginInfo);
                Map<String, Object> userConf = new UserService(user, activity).signInWithJWT(user.getTel());
                if(userConf.get(MESSAGE).equals(CONNECTED)){
                    loginResultIntent = new Intent(activity, FilActualiteActivity.class);
                    activity.startActivity(loginResultIntent);
                } else {
                    Toast.makeText(activity, (String)userConf.get(MESSAGE), Toast.LENGTH_LONG);
                }
            } else if(loginInfo.get(MESSAGE).equals(ERROR_OCCURRED)){

            }

        return null;
    }
}
