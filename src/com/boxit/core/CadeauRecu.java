package com.boxit.core;

import java.util.Date;

public class CadeauRecu extends Cadeau{

	

	/**
	 * fermer si close est a true
	 */
	private boolean close;
	
	public CadeauRecu(String titre,int type, String url, String dateDebut, String dateFin,
			double longitude, double latitude, int rayon,String pseudo_client, String legende, boolean close) {
		
		super(url,pseudo_client,type,longitude,latitude,titre,rayon,dateDebut,dateFin,legende);
		this.setClose(true);
		
	}

	public boolean isClose() {
		return close;
	}

	public void setClose(boolean close) {
		this.close = close;
	}
	
	

}
