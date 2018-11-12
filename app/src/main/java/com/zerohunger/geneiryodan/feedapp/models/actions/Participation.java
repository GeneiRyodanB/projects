package com.zerohunger.geneiryodan.feedapp.models.actions;


import com.zerohunger.geneiryodan.feedapp.models.users.User;

public class Participation {

	private Long id;

	private ParticipationType  partiType;

	private User participant;

	private Action action;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ParticipationType getPartiType() {
		return partiType;
	}

	public void setPartiType(ParticipationType partiType) {
		this.partiType = partiType;
	}

	public User getParticipant() {
		return participant;
	}

	public void setParticipant(User participant) {
		this.participant = participant;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}
	
	
}
