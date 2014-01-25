package com.boxit.data;

import com.boxit.core.Client;
import com.boxit.core.Cadeau;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DataControl {

	private SQLiteDatabase bdd;
	private MaBaseSQLite maBaseSQLite;

	private Context context;

	private String[] allColumns_client = {MaBaseSQLite.COL_PSEUDO,MaBaseSQLite.COL_NOM,
			MaBaseSQLite.COL_PRENOM,MaBaseSQLite.COL_DATE_NAISSANCE,
			MaBaseSQLite.COL_TEL,MaBaseSQLite.COL_MAIL,MaBaseSQLite.COL_PASSWORD};

	private String[] allColumns_contact = {MaBaseSQLite.COL_PSEUDO_CLIENT,MaBaseSQLite.COL_PSEUDO_CONTACT};

	private String[] allColumns_cadeau = {MaBaseSQLite.COL_CADEAU_URL,MaBaseSQLite.COL_CADEAU_PSEUDO_EMETTEUR,
			MaBaseSQLite.COL_CADEAU_TYPE,MaBaseSQLite.COL_LONG,
			MaBaseSQLite.COL_LAT,MaBaseSQLite.COL_CADEAU_TITRE,MaBaseSQLite.COL_RADIUS,
			MaBaseSQLite.COL_CAD_DATE_OPEN,MaBaseSQLite.COL_CAD_DATE_CLOSE,MaBaseSQLite.COL_CAD_ISOPEN,
			MaBaseSQLite.COL_CADEAU_LEGENDE};
	

	public DataControl(Context context){
		//On créer la BDD et sa table
		maBaseSQLite = new MaBaseSQLite(context);
		//maBaseSQLite.onCreate(bdd);
		this.context=context;
	}

	public void open() throws SQLException {
		//on ouvre la BDD en écriture
		bdd = maBaseSQLite.getWritableDatabase();
	}

	public void close(){
		//on ferme l'accès à la BDD
		maBaseSQLite.close();
	}

	// pour l'inscriptionActivity
	public void insertClient(Client client){
		//Création d'un ContentValues (fonctionne comme une HashMap)
		ContentValues values = new ContentValues();
		//on lui ajoute une valeur associé à une clé (qui est le nom de la colonne dans laquelle on veut mettre la valeur)
		values.put(MaBaseSQLite.COL_PSEUDO, client.getPseudo());
		values.put(MaBaseSQLite.COL_NOM, client.getName());
		values.put(MaBaseSQLite.COL_PRENOM, client.getFirstName());
		values.put(MaBaseSQLite.COL_DATE_NAISSANCE, client.getDateBirth());
		values.put(MaBaseSQLite.COL_TEL,client.getTelNum());
		values.put(MaBaseSQLite.COL_MAIL,client.getMail());
		values.put(MaBaseSQLite.COL_PASSWORD, client.getMdp());
		//on insère l'objet dans la BDD via le ContentValues
		bdd.insert(MaBaseSQLite.TABLE_CLIENT, null, values);
	}


	// TODO mieux de demander le client total en argument
	public void insertContact(String pseudo_client, String pseudo_contact){

        
		ContentValues values = new ContentValues();

		values.put(MaBaseSQLite.COL_PSEUDO_CLIENT, pseudo_client);
		values.put(MaBaseSQLite.COL_PSEUDO_CONTACT, pseudo_contact);

		bdd.insert(MaBaseSQLite.TABLE_CONTACT_CLIENT, null, values);

	}


	public void insertCadeau(Cadeau cadeau){

		ContentValues values = new ContentValues();

		values.put(MaBaseSQLite.COL_CADEAU_URL, cadeau.getUrl());
		values.put(MaBaseSQLite.COL_CADEAU_PSEUDO_EMETTEUR, cadeau.getPseudoClient());
		values.put(MaBaseSQLite.COL_CADEAU_TYPE, cadeau.getType());
		values.put(MaBaseSQLite.COL_LONG, cadeau.getLongitude());
		values.put(MaBaseSQLite.COL_LAT, cadeau.getLatitude());
		values.put(MaBaseSQLite.COL_CADEAU_TITRE, cadeau.getTitre());
		values.put(MaBaseSQLite.COL_RADIUS, cadeau.getRayon());
		values.put(MaBaseSQLite.COL_CAD_DATE_OPEN, cadeau.getDateDebut());
		values.put(MaBaseSQLite.COL_CAD_DATE_CLOSE, cadeau.getDateFin());
		values.put(MaBaseSQLite.COL_CAD_ISOPEN,0);
		values.put(MaBaseSQLite.COL_CADEAU_LEGENDE, cadeau.getLegende());

		bdd.insert(MaBaseSQLite.TABLE_CADEAU, null, values);

	}

	// pour la desinscriptionActivity
	public int removeClientWithPseudo(String pseudo){
		//Suppression d'un client de la BDD grâce à son pseudo
		return bdd.delete(MaBaseSQLite.TABLE_CLIENT, MaBaseSQLite.COL_PSEUDO + " = '" + pseudo +"'", null);
	}

	//  TODO mettre fonction qui bouge un contact

	/**
	 * @param pseudo
	 * @return True si pseudo correspondant a un client dans la db
	 */
	public boolean existsClientWithPseudo(String pseudo) {
		Cursor c = bdd.query(MaBaseSQLite.TABLE_CLIENT,allColumns_client,MaBaseSQLite.COL_PSEUDO +" = '" + pseudo +"'", null,null,null,null);
		int result = c.getCount();
		c.close();
		return result==1;
	}

	/**
	 * @param pseudo du contact, pseudo du client
	 * @return  retourne true si le contact est deja dans la liste de contact du client
	 */ 

	public boolean alreadyContact(String pseudo_client, String pseudo_contact) {
		Cursor c = bdd.rawQuery("SELECT pseudo_client, pseudo_contact FROM Contact_client WHERE pseudo_client = '"+pseudo_client+"' AND pseudo_contact = '"+pseudo_contact+"'", null);
		int result = c.getCount();
		c.close();
		return result==1;
	}  



	/**
	 * @param mail
	 * @return True si mail correspondant a un client dans la db
	 */
	public boolean existsClientWithMail(String mail) {
		Cursor c = bdd.query(MaBaseSQLite.TABLE_CLIENT,allColumns_client,MaBaseSQLite.COL_MAIL +" = '" + mail +"'", null,null,null,null);
		int result = c.getCount();
		c.close();
		return result==1;
	}

	/**
	 * @param mail
	 * @return True si tel correspondant a un client dans la db
	 */
	public boolean existsClientWithTel(String tel) {
		Cursor c = bdd.query(MaBaseSQLite.TABLE_CLIENT,allColumns_client,MaBaseSQLite.COL_TEL +" = '" + tel +"'", null,null,null,null);
		int result = c.getCount();
		c.close();
		return result==1;
	}

	/**
	 * @param 
	 * @return
	 */
	public boolean logIn(String pseudo,String mdp)
	{
		if(!(existsClientWithPseudo(pseudo)))
		{
			return false;
		}
		Cursor c = bdd.query(MaBaseSQLite.TABLE_CLIENT,allColumns_client,MaBaseSQLite.COL_PSEUDO +" = '" + pseudo +"'", null,null,null,null);
		//Sinon on se place sur le premier élément
		c.moveToFirst();
		boolean result = c.getString(6).equals(mdp);
		c.close();
		return result;
	}

	//TODO changer apres pour que ça fonctionne ac mail num et pseudo et pas juste pseudo
	// pour la connextionActivity
	public Client getClientWithPseudo(String pseudo){
		//Récupère dans un Cursor les valeur correspondant à un client contenu dans la BDD (ici on sélectionne le client grâce à son pseudo)
		Cursor c = bdd.query(MaBaseSQLite.TABLE_CLIENT,allColumns_client,MaBaseSQLite.COL_PSEUDO +" = '" + pseudo +"'", null,null,null,null);
		return cursorToClient(c);
	}
	
	public Cadeau getCadeauWithUrl(String url){
		//Récupère dans un Cursor les valeur correspondant à un client contenu dans la BDD (ici on sélectionne le client grâce à son pseudo)
		Cursor c = bdd.query(MaBaseSQLite.TABLE_CADEAU,allColumns_cadeau,MaBaseSQLite.COL_CADEAU_URL +" = '" + url +"'", null,null,null,null);
		return cursorToCadeau(c);
	}
	


	//Cette méthode permet de convertir un cursor en un client
	private Client cursorToClient(Cursor c){
		//si aucun élément n'a été retourné dans la requête, on renvoie null
		if (c.getCount() == 0)
			return null;

		//Sinon on se place sur le premier élément
		c.moveToFirst();
		//On créé un livre et on lui affecte toutes les infos grâce aux infos contenues dans le Cursor
		Client client = new Client(c.getString(0),c.getString(1),c.getString(2),
				c.getString(3),c.getString(4),c.getString(5),
				c.getString(6));

		//On ferme le cursor
		c.close();

		//On retourne le client
		return client;
	}
	//Cette méthode permet de convertir un cursor en un client
	
	private Cadeau cursorToCadeau(Cursor c){
		//si aucun Cadeau n'est ne correspond a lurl, on renvoi null
		if (c.getCount() == 0)
			return null;
		//Sinon on se place sur le premier élément
		c.moveToFirst();
		//On créé un livre et on lui affecte toutes les infos grâce aux infos contenues dans le Cursor
		Cadeau cadeau = new Cadeau(c.getString(0),c.getString(1),c.getInt(2),
				c.getDouble(3),c.getDouble(4),c.getString(5),c.getInt(6),c.getString(7),
				c.getString(8),c.getString(10));

		//On ferme le cursor
		c.close();

		//On retourne le client
		return cadeau;
	}
}