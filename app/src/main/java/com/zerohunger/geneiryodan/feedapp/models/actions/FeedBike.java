package com.zerohunger.geneiryodan.feedapp.models.actions;


import java.time.LocalDate;
import java.time.LocalTime;


public class FeedBike extends Action {

    private int nbCollecte;

	private int collecteReserve;
	

    public FeedBike() {
    }

    public FeedBike(LocalDate date, LocalTime time, int nbPreparation, int nbDistribution, int nbCollecte) {
        super(date, time, nbPreparation, nbDistribution);
        this.nbCollecte = nbCollecte;
    }

    public int getNbCollecte() {
        return nbCollecte;
    }

    public void setNbCollecte(int nbCollecte) {
        this.nbCollecte = nbCollecte;
    }
    
    public int getCollecteReserve() {
    	return collecteReserve;
    }
    
    public void setCollecteReserve(int collecteReserve) {
    	this.collecteReserve = collecteReserve;
    }
}