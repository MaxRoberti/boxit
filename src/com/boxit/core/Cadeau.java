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
	private Date dateDebut;



	/**
	 * Represente la date du fin d activation du cadeau.
	 */
	private Date dateFin;


	/**
	 * Représente les coordonnées GPS et le rayon du cadeau.
	 */
	private double longitude, latitude , rayon;


	/**
	 * represent le client assosie au cadeau
	 */
	private Client client;


	/**
	 * constructeur pour les cadeau temps
	 */
	public Cadeau(String titre,int type, String url,Date dateDebut,Date dateFin,double longitude,double latitude,double rayon, Client client ){

		this.titre= titre;
		this.type=type;
		this.url=url;
		this.dateDebut=dateDebut;
		this.dateFin=dateFin;
		this.longitude=longitude;
		this.latitude=latitude;
		this.rayon=rayon;
		this.client=client;
	}

	public String getTitre(){
		return titre;
	}

	public void setTitre(String titre){
		this.titre=titre;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
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

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
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

	public double getRayon() {
		return rayon;
	}

	public void setRayon(double rayon) {
		this.rayon = rayon;
	}


}
