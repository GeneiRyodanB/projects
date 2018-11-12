package com.zerohunger.geneiryodan.feedapp.services;


import android.app.Activity;

import com.zerohunger.geneiryodan.feedapp.models.actions.Action;
import com.zerohunger.geneiryodan.feedapp.models.users.User;

import java.util.Map;

public class ActionService extends Service<Action> {

    private final String urnAddAction = "postAction";
    private final String urnUpdateAction = "updateAction";
    private final String urnCloseAction = "closeAction";

    public ActionService(Activity activity, User user) {
        super(activity, user);
    }

    public Map<String, ?> addAction(Action action){
        Map<String, ?> result = processRequest(action, urnAddAction);
        return result;
    }

    public Map<String, ?> updateAction(Action action){
        Map<String, ?> result = processRequest(action, urnUpdateAction);
        return result;
    }

    public Map<String, ?> closeAction(Action action){
        Map<String, ?> result = processRequest(action, urnCloseAction);
        return result;
    }
}
