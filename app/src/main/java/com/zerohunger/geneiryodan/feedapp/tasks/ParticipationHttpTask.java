package com.zerohunger.geneiryodan.feedapp.tasks;

import android.app.Activity;
import android.os.AsyncTask;

import com.zerohunger.geneiryodan.feedapp.models.actions.Participation;
import com.zerohunger.geneiryodan.feedapp.models.users.User;
import com.zerohunger.geneiryodan.feedapp.services.ParticipationService;

import java.util.HashMap;
import java.util.Map;

import static com.zerohunger.geneiryodan.feedapp.constants.MessageConstant.ERROR_OCCURRED;
import static com.zerohunger.geneiryodan.feedapp.constants.MessageConstant.MESSAGE;
import static com.zerohunger.geneiryodan.feedapp.constants.OperationsConstant.LEAVE_ACTION;
import static com.zerohunger.geneiryodan.feedapp.constants.OperationsConstant.PARTICIPATE_TO_ACTION;
import static com.zerohunger.geneiryodan.feedapp.constants.OperationsConstant.UPDATE_PARTICIPATION;

public class ParticipationHttpTask extends AsyncTask<Void, Void, Map> {

    private Activity activity;
    private User user;
    private Participation participation;
    private String operation;

    public ParticipationHttpTask(Activity activity, User user, Participation participation, String operation) {
        this.activity = activity;
        this.user = user;
        this.participation = participation;
        this.operation = operation;
    }
    @Override
    protected Map doInBackground(Void... voids) {
        Map<String, ?> result;
        switch(operation){
            case PARTICIPATE_TO_ACTION :
                result = new ParticipationService(activity, user).participateToAction(participation);
                break;
            case UPDATE_PARTICIPATION :
                result = new ParticipationService(activity, user).updateParticipation(participation);
                break;
            case LEAVE_ACTION :
                result = new ParticipationService(activity, user).leaveAction(participation);
                break;
            default :
                result = new HashMap<String, String>();
                ((HashMap<String, String>)result).put(MESSAGE, ERROR_OCCURRED);
                break;
        }

        return result;
    }

}
