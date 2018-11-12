package com.zerohunger.geneiryodan.feedapp.models.actions;

import com.zerohunger.geneiryodan.feedapp.models.users.User;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.List;

public abstract class Action {

	protected Long Id;

    protected LocalDate date;

    protected LocalTime time;

    protected int nbPreparation;

	protected int preparationReserve;

    protected int nbDistribution;

	protected int distributionReserve;

    protected List<Participation> participations;

    protected User createdBy;

    protected Besoin besoin;

    public Action(){}

    public Action(LocalDate date, LocalTime time, int nbPreparation, int nbDistribution) {
        this.date = date;
        this.time = time;
        this.nbPreparation = nbPreparation;
        this.nbDistribution = nbDistribution;
    }
    
    
    
    public Action(Long id, LocalDate date, LocalTime time, int nbPreparation, int nbDistribution,
			List<Participation> participations, User createdBy, Besoin besoin) {
		super();
		Id = id;
		this.date = date;
		this.time = time;
		this.nbPreparation = nbPreparation;
		this.nbDistribution = nbDistribution;
		this.createdBy = createdBy;
		this.participations = participations;
		this.besoin = besoin;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public int getNbPreparation() {
        return nbPreparation;
    }

    public void setNbPreparation(int nbPreparation) {
        this.nbPreparation = nbPreparation;
    }

    public int getNbDistribution() {
        return nbDistribution;
    }

    public void setNbDistribution(int nbDistribution) {
        this.nbDistribution = nbDistribution;
    }

	public List<Participation> getParticipations() {
		return participations;
	}

	public void setParticipations(List<Participation> participations) {
		this.participations = participations;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}
	
	public Besoin getBesoin() {
		return besoin;
	}
	
	public void setBesoin(Besoin besoin) {
		this.besoin = besoin;
	}

	public int getPreparationReserve() {
		return preparationReserve;
	}

	public void setPreparationReserve(int preparationReserve) {
		this.preparationReserve = preparationReserve;
	}

	public int getDistributionReserve() {
		return distributionReserve;
	}

	public void setDistributionReserve(int distributionReserve) {
		this.distributionReserve = distributionReserve;
	}

	public boolean add(Participation arg0) {
		return participations.add(arg0);
	}

	public boolean addAll(Collection<? extends Participation> arg0) {
		return participations.addAll(arg0);
	}

	public void clear() {
		participations.clear();
	}

	public boolean contains(Object arg0) {
		return participations.contains(arg0);
	}

	public boolean containsAll(Collection<?> arg0) {
		return participations.containsAll(arg0);
	}

	public Participation get(int arg0) {
		return participations.get(arg0);
	}

	public boolean isEmpty() {
		return participations.isEmpty();
	}

	public Participation remove(int arg0) {
		return participations.remove(arg0);
	}

	public boolean remove(Object arg0) {
		return participations.remove(arg0);
	}

	public boolean removeAll(Collection<?> arg0) {
		return participations.removeAll(arg0);
	}

	public int size() {
		return participations.size();
	}
    
    

    
}
