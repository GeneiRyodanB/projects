package com.zerohunger.geneiryodan.feedapp.models.actualites;

import com.zerohunger.geneiryodan.feedapp.models.actions.Action;

import java.util.List;

public class FilActualite {

	private List<Action> actions;
	private Filtre filtre;
	
	public FilActualite() {
		
	}
	
	public FilActualite(List<Action> actions, Filtre filtre) {
		this.actions = actions;
		this.filtre = filtre;
	}

	public List<Action> getActions() {
		return actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

	public Filtre getFiltre() {
		return filtre;
	}

	public void setFiltre(Filtre filtre) {
		this.filtre = filtre;
	}
	
	public void doFiltre() {
		// Appliquer le filtre
	}
}
