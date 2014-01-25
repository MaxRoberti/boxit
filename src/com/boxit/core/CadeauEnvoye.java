package com.boxit.core;

import java.util.ArrayList;
import java.util.Date;

public class CadeauEnvoye extends Cadeau{
	
	

	/**
	 * represent la liste de contact qui n a pas ouvert le dossier
	 */
	private ArrayList<Contact> listContactClose;
	
	/**
	 * represent la liste de contact qui a ouvert le dossier
	 */
	private ArrayList<Contact> listContactOpen;
	
	
	public CadeauEnvoye(String titre,int type, String url, String dateDebut, String dateFin,
			double longitude, double latitude, int rayon, String pseudo_client, String legende,
			ArrayList<Contact> listContactClose,ArrayList<Contact> listContactOpen) {
		super(url,pseudo_client,type,longitude,latitude,titre,rayon,dateDebut,dateFin,legende);
		this.listContactClose=listContactClose;
	}


	public ArrayList<Contact> getListContactClose() {
		return listContactClose;
	}


	public void setListContactClose(ArrayList<Contact> listContactClose) {
		this.listContactClose = listContactClose;
	}


	public ArrayList<Contact> getListContactOpen() {
		return listContactOpen;
	}


	public void setListContactOpen(ArrayList<Contact> listContactOpen) {
		this.listContactOpen = listContactOpen;
	}
	/**
	 * fonction qui switch un contact de la liste contactclose a la liste contactopen
	 * @param contact
	 */
	public void switchContactCloseToContactOpen(Contact contact){
		if(listContactClose.remove(contact))
		{
			listContactOpen.add(contact);
		}
	}
	
}
