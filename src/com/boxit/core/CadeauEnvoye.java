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
	
	
	public CadeauEnvoye(String titre,int type, String url, Date dateDebut, Date dateFin,
			double longitude, double latitude, double rayon, Client client,
			ArrayList<Contact> listContactClose,ArrayList<Contact> listContactOpen) {
		super(titre, type, url, dateDebut, dateFin, longitude, latitude, rayon, client);
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
