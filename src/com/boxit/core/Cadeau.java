package com.boxit.core;

import java.util.ArrayList;
import java.util.Date;



public class Cadeau {

	//DOTO j ai pas mis le "type" car on peut le savoir en regardant si dateDebut et DateFin est null et etc bref demandez a Shark


	private String titre;

	/**
	 * Represente le type de document (video,photo etc.)
	 */
	private int type;

	private String url;

	/**
	 * Represente la date du debut d activation du cadeau.
	 */
	private String dateDebut;



	/**
	 * Represente la date du fin d activation du cadeau.
	 */
	private String dateFin;


	/**
	 * Représente les coordonnées GPS et le rayon du cadeau.
	 */
	private double longitude, latitude;


	private int rayon;
	/**
	 * represent le client assosie au cadeau
	 */
	private String pseudo_client;
	
	/**
	 * represent le client assosie au cadeau
	 */
	private String legende;
	


	/**
	 * constructeur pour les cadeau temps
	 */         
	public Cadeau(String url, String pseudo_client, int type, double longitude,double latitude, String titre, int rayon,String dateDebut,String dateFin, String legende){
		this.titre= titre;
		this.type=type;
		this.url=url;
		this.dateDebut=dateDebut;
		this.dateFin=dateFin;
		this.longitude=longitude;
		this.latitude=latitude;
		this.rayon=rayon;
		this.pseudo_client=pseudo_client;
		this.legende =legende;
	}

	public String getTitre(){
		return titre;
	}

	public void setTitre(String titre){
		this.titre=titre;
	}

	public String getPseudoClient() {
		return pseudo_client;
	}
	
	public void setPseudoClient(String pseudo_client) {
		this.pseudo_client = pseudo_client;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}

	public String getDateFin() {
		return dateFin;
	}

	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public int getRayon() {
		return rayon;
	}

	public void setRayon(int rayon) {
		this.rayon = rayon;
	}
	
	public String getLegende() {
		return legende;
	}
	
	public void setLegende(String legende) {
		this.legende = legende;
	}
	
	


}
