package com.zerohunger.geneiryodan.feedapp.models.users;

import com.zerohunger.geneiryodan.feedapp.models.SansAbris.SDF;
import com.zerohunger.geneiryodan.feedapp.models.actions.Action;
import com.zerohunger.geneiryodan.feedapp.models.actions.Participation;

import java.util.List;
import java.util.Objects;

public class User {

	private Long id;
	
    private String nom;
    private String prenom;
    private String email;
    private String tel;
    private String ville;
    private String password;
    private Role role;
    private List<Action> mesActions;
    private List<Participation> participations;
    private List<SDF> sansAbris;

    public User() {}

    public User(String tel, String password){
        this.tel = tel;
        this.password = password;
    }

    public User(String nom, String prenom, String email, String tel, String ville, String password, Role role) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.tel = tel;
        this.ville = ville;
        this.password = password;
        this.role = role;
    }
    
    

    public User(Long id, String nom, String email, String tel, String ville, String password, Role role,
			List<Action> mesActions, List<SDF> sansAbris) {
		super();
		this.id = id;
		this.nom = nom;
		this.email = email;
		this.tel = tel;
		this.ville = ville;
		this.password = password;
		this.role = role;
		this.mesActions = mesActions;
		this.sansAbris = sansAbris;
	}

    public User(Long id, String nom, String email, String tel, String ville, String password, Role role,
			List<Action> mesActions, List<SDF> sansAbris, List<Participation> participations) {
		super();
		this.id = id;
		this.nom = nom;
		this.email = email;
		this.tel = tel;
		this.ville = ville;
		this.password = password;
		this.role = role;
		this.mesActions = mesActions;
		this.sansAbris = sansAbris;
		this.participations = participations;
	}

	public static User buildUser(String nom, String prenom, String email, String tel, String ville, String password, String role){
        Role userRole = new Role(role);
        return new User(nom, prenom, email, tel, ville, password, userRole);
    }
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int participerAction(Action action){
        return 0;
    }
    
    public void setRole(Role role) {
    	this.role = role;
    }
    
    public Role getRole() {
    	return role;
    }
    
    public void setMesActions(List<Action> mesActions) {
    	this.mesActions = mesActions;
    }
    
    public List<Action> getMesActions(){
    	return mesActions;
    }
    
    public List<Participation> getParticipations() {
		return participations;
	}

	public void setParticipations(List<Participation> participations) {
		this.participations = participations;
	}

	public void setSansAbris(List<SDF> sansAbris) {
    	this.sansAbris = sansAbris;
    }

    public List<SDF> getSansAbris(){
    	return sansAbris;
    }
    
    public void minimizeInfo() {
    	id = null;
    	password = "";
    	mesActions = null;
    	participations = null;
    	sansAbris = null;
    }
    
    @Override
    public String toString() {
        return "User{" +
                "nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                ", tel='" + tel + '\'' +
                ", ville='" + ville + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }




}
