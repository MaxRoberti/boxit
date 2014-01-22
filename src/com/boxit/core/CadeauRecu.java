package com.boxit.core;

import java.util.Date;

public class CadeauRecu extends Cadeau{

	

	/**
	 * fermer si close est a true
	 */
	private boolean close;
	
	public CadeauRecu(String titre,int type, String url, Date dateDebut, Date dateFin,
			double longitude, double latitude, double rayon, Client client,boolean close) {
		
		super(titre,type, url, dateDebut, dateFin, longitude, latitude, rayon, client);
		this.setClose(true);
		
	}

	public boolean isClose() {
		return close;
	}

	public void setClose(boolean close) {
		this.close = close;
	}
	
	
	


}
