package com.boxit.core;

import java.util.ArrayList;
import java.util.Date;

public class Client {
	
	/**
	 * represente le pseudo de l utilisateur
	 */
	private String pseudo;

	/**
	 * represente le mail de l utilisateur.
	 */
	private String mail;

	/**
	 * represente le nom de l utilisateur.
	 */
	private String name;

	/**
	 * represente le prenom de l utilisateur.
	 */
	private String firstName;

	/**
	 * represente le numero de telephone de l utilisateur.
	 */
	//TODO string???
	private String telNum;
	
	/**
	 * represente la date de naissance de l utilisateur
	 */
	private Date dateBirth;
	
	/**
	 * represente le mot de passe de l utilisateur
	 */
	//TODO a revoir pour criptage
	private String mdp;
	
	/**
	 * represente la liste de contact de l utilisateur
	 */
	private ArrayList<Contact> listContact;
	
	/**
	 * represent la liste de cadeaux envoye
	 */
	private ArrayList<Cadeau> listCadeauSent;
	
	/**
	 * represente la liste de cadeaux recu
	 */
	private ArrayList<Cadeau> listCadeauReceived;
	
	/**
	 * Constructeur motherfucker!!
	 * 
	 */
	public Client(String pseudo,String mail,String name,String firstName,String telNum,
			Date dateBirth,String mdp)
	{
		this.pseudo = pseudo;
		this.mail = mail;
		this.name = name;
		this.firstName = firstName;
		this.telNum = telNum;
		this.dateBirth = dateBirth;
		this.mdp = mdp;
		this.listContact = null;
		this.listCadeauSent = null;
		this.listCadeauReceived = null;
	}
	
	public String getPseudo() {
		return pseudo;
	}
	
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getFirstName(){
		return firstName;
	}
	
	public void setFristName(String firstName){
		this.firstName = firstName;
	}
	
	public String getTelNum(){
		return telNum;
	}
	
	public void setTelNum(String telNum){
		this.telNum = telNum;
	}
	
	public Date getDateBirth(){
		return dateBirth;
	}
	
	public void setDateBirth(Date datebirth){
		this.dateBirth = dateBirth;
	}
	
	public String getMdp(){
		return mdp;
	}
	
	public void setMdp(){
		this.mdp = mdp;
	}
	
	public ArrayList<Contact> getListContact(){
		return listContact;
	}
	//TODO utile??
	public void setListContact( ArrayList<Contact> listContact){
		this.listContact = listContact;
	}
	
	public void addContact(Contact contact)
	{
		if(contact != null)
			listContact.add(contact);
	}
	
	public void removeContact(Contact contact)
	{
		listContact.remove(contact);
	}
	
	public ArrayList<Cadeau> getListCadeauSend(){
		return listCadeauSent;
	}
	
	//TODO utile??
	public void setListCadeau(ArrayList<Cadeau> listCadeauSent){
		this.listCadeauSent=listCadeauSent;
	}
	
	public void addCadeauSent(Cadeau cadeau){
		if(cadeau != null)
			listCadeauSent.add(cadeau);
	}
	
	public void removeCadeauSent(Cadeau cadeau){
		listCadeauSent.remove(cadeau);
	}
	
	public ArrayList<Cadeau> getListCadeauReceived(){
		return listCadeauReceived;
	}
	//TODO utile??
	public void setListCadeauReceived(ArrayList<Cadeau> listCadeauReceived){
		this.listCadeauReceived=listCadeauReceived;
	}
	
	public void addCadeauReceived(Cadeau cadeau){
		if(cadeau != null)
			listCadeauReceived.add(cadeau);
	}
	
	public void removeCadeauReceived(Cadeau cadeau){
		listCadeauReceived.remove(cadeau);
	}
	
	/* METHODE STATIC
	 ******************************
	 */
	public static boolean isClientInDateBase(String pseudo,String mail,String telNum)
	{
		
		return true;
	}
}
