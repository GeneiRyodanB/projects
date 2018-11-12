package com.zerohunger.geneiryodan.feedapp.services;

import android.app.Activity;

import com.zerohunger.geneiryodan.feedapp.models.actions.Participation;
import com.zerohunger.geneiryodan.feedapp.models.users.User;

import java.util.Map;

public class ParticipationService extends Service<Participation> {

    private final String urnParticipateToAction = "particpateToAction";
    private final String urnLeaveAction = "leaveAction";
    private final String urnLUpdateParticipation = "updateParticipation";

    public ParticipationService(Activity activity, User user) {
        super(activity, user);
    }

    public Map<String, ?> participateToAction(Participation participation){
        Map<String, ?> result = processRequest(participation, urnParticipateToAction);
        return result;
    }

    public Map<String, ?> leaveAction(Participation participation){
        Map<String, ?> result = processRequest(participation, urnLeaveAction);
        return result;
    }

    public Map<String, ?> updateParticipation(Participation participation){
        Map<String, ?> result = processRequest(participation, urnLUpdateParticipation);
        return result;
    }
}
