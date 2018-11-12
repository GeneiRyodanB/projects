package com.zerohunger.geneiryodan.feedapp.models.actions;

import com.zerohunger.geneiryodan.feedapp.models.SansAbris.Coordonnee;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.List;


public class FeedAct extends Action {

	private int achatReserve;

    private Coordonnee meetingPoint;

    public FeedAct() {
    }

    public FeedAct(LocalDate date, LocalTime time, int nbPreparation, int nbDistribution, Coordonnee meetingPoint) {
        super(date, time, nbPreparation, nbDistribution);
        this.meetingPoint = meetingPoint;
    }
    
    public void setMeetingPoint(Coordonnee meetingPoint) {
    	this.meetingPoint = meetingPoint;
    }
    
    public Coordonnee getMeetingPoint() {
    	return meetingPoint;
    }

	public int getAchatReserve() {
		return achatReserve;
	}

	public void setAchatReserve(int achatReserve) {
		this.achatReserve = achatReserve;
	}
     
}
