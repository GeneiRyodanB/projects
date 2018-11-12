package com.zerohunger.geneiryodan.feedapp.tasks;

import android.app.Activity;
import android.os.AsyncTask;

import com.zerohunger.geneiryodan.feedapp.models.actions.Action;
import com.zerohunger.geneiryodan.feedapp.models.users.User;
import com.zerohunger.geneiryodan.feedapp.services.ActionService;

import java.util.HashMap;
import java.util.Map;

import static com.zerohunger.geneiryodan.feedapp.constants.MessageConstant.ERROR_OCCURRED;
import static com.zerohunger.geneiryodan.feedapp.constants.MessageConstant.MESSAGE;
import static com.zerohunger.geneiryodan.feedapp.constants.OperationsConstant.ADD_ACTION;
import static com.zerohunger.geneiryodan.feedapp.constants.OperationsConstant.CLOSE_ACTION;
import static com.zerohunger.geneiryodan.feedapp.constants.OperationsConstant.UPDATE_ACTION;

public class ActionHttpTask extends AsyncTask<Void, Void, Map> {

    private Activity activity;
    private User user;
    private Action action;
    private String operation;

    public ActionHttpTask(Activity activity, User user, Action action, String operation) {
        this.activity = activity;
        this.user = user;
        this.action = action;
        this.operation = operation;
    }
    @Override
    protected Map doInBackground(Void... voids) {
        Map<String, ?> result;
        switch(operation){
            case ADD_ACTION :
                result = new ActionService(activity, user).addAction(action);
                break;
            case UPDATE_ACTION :
                result = new ActionService(activity, user).updateAction(action);
                break;
            case CLOSE_ACTION :
                result = new ActionService(activity, user).closeAction(action);
                break;
            default :
                result = new HashMap<String, String>();
                ((HashMap<String, String>)result).put(MESSAGE, ERROR_OCCURRED);
                break;
        }

        return result;
    }

}
