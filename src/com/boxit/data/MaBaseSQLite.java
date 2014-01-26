package com.boxit.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MaBaseSQLite extends SQLiteOpenHelper{
	
	
	
	// Table Client
	public static final String TABLE_CLIENT = "Client";
	public static final String COL_PSEUDO = "pseudo";
	public static final String COL_NOM = "nom";
	public static final String COL_PRENOM = "prenom";
	public static final String COL_DATE_NAISSANCE ="dateNaissance";
	public static final String COL_TEL = "tel";
	public static final String COL_MAIL = "mail";
	public static final String COL_PASSWORD = "password";
	
	
	// Table Contact
	public static final String TABLE_CONTACT_CLIENT = "Contact_client";
	public static final String COL_PSEUDO_CLIENT = "pseudo_client";
	public static final String COL_PSEUDO_CONTACT = "pseudo_contact";
	
	// Table Cadeau Client
	
	public static final String TABLE_CADEAU = "Cadeau";
	public static final String COL_CADEAU_URL= "cadeau_url";
	public static final String COL_CADEAU_TYPE= "cadeau_type";
	public static final String COL_CADEAU_PSEUDO_EMETTEUR = "pseudo_emetteur";
	public static final String COL_CADEAU_TITRE = "cadeau_titre";
	public static final String COL_CADEAU_LEGENDE = "cadeau_legende";
	public static final String COL_LONG = "cadeau_longitude";
	public static final String COL_LAT = "cadeau_latitude";
	public static final String COL_RADIUS = "cadeau_rayon";
	public static final String COL_CAD_DATE_OPEN = "cadeau_date_open";
	public static final String COL_CAD_DATE_CLOSE = "cadeau_date_close";
	
	// Table Cadeau Contact
	
	public static final String TABLE_CADEAU_CONTACT = "Cadeau_contact";
	public static final String COL_CADEAU_URL2= "cadeau_url2";
	public static final String COL_CADEAU_PSEUDO_CONTACT= "cadeau_pseudo_contact";
	public static final String COL_CADEAU_ISOPEN= "cadeau_isOpen";
	

	

	private static final int VERSION_BDD = 1;
	private static final String NOM_BDD = "boxit.db";

	
	// Creation table Client 
	private static final String CREATE_TABLE_CLIENT = " create table " + TABLE_CLIENT + "("
			+COL_PSEUDO+ " text primary key not null unique , " +COL_NOM+ " text not null , "
			+COL_PRENOM+ " text not null , "+COL_DATE_NAISSANCE+ " text not null , "
			+COL_TEL+ " text not null , "+COL_MAIL+ " text not null , "
			+COL_PASSWORD+" text not null);";

	// Création table Contact CLient
	private static final String CREATE_TABLE_CONTACT_CLIENT = " create table " + TABLE_CONTACT_CLIENT 
			+ "(" +COL_PSEUDO_CLIENT+ " text not null unique , "
			+ COL_PSEUDO_CONTACT+ " text not null , " 
			+  "primary key( " + COL_PSEUDO_CLIENT + "," + COL_PSEUDO_CONTACT + "));";
	
	// Création table Contact Cadeau
		private static final String CREATE_TABLE_CADEAU_CONTACT = " create table " + TABLE_CADEAU_CONTACT 
				+ "(" +COL_CADEAU_URL2+ " text not null , "
				+ COL_CADEAU_PSEUDO_CONTACT+ " text not null , " 
				+ COL_CADEAU_ISOPEN+ " bit not null , " 
				+  "primary key( " + COL_CADEAU_URL2 + "," + COL_PSEUDO_CONTACT + "));";
	
	
	// Création table Cadeau
	private static final String CREATE_TABLE_CADEAU = " create table " + TABLE_CADEAU
			+ "(" +COL_CADEAU_URL+ " text primary key not null unique , "
			+ COL_CADEAU_PSEUDO_EMETTEUR+ " text not null , " 
			+ COL_CADEAU_TYPE+ " int not null , "
			+ COL_LONG+ " double not null , "
			+ COL_LAT+  " double not null , "
			+ COL_CADEAU_TITRE+ " text not null , "
			+ COL_RADIUS+ " int not null , "
			+ COL_CAD_DATE_OPEN+ " date not null , "
			+ COL_CAD_DATE_CLOSE+ " date not null , "
			+ COL_CADEAU_LEGENDE + " text);";
	
	
	
	
	
	/*private static final String CREATE_BDD = "CREATE TABLE \"Client\" (" +
			"\"pseudo\" VARCHAR PRIMARY KEY NOT NULL UNIQUE," +
			"\"nom\" VARCHAR NOT NULL," +
			"\"prenom\" VARCHAR NOT NULL," +
			"\"dateNaissance\" DATE NOT NULL," +
			"\"tel\" VARCHAR NOT NULL UNIQUE," +
			"\"mail\" VARCHAR NOT NULL UNIQUE," +
			"\"password\" VARCHAR NOT NULL);";*/
	
	public MaBaseSQLite(Context context) {
		super(context,NOM_BDD, null, VERSION_BDD);
	}
	

	@Override
	public void onCreate(SQLiteDatabase db) {
		//on cree la table a partir de la requ√™te ecrite dans la variable CREATE_BDD
		db.execSQL("drop table if exists " + TABLE_CLIENT + ";");
		db.execSQL("drop table if exists " + TABLE_CONTACT_CLIENT + ";");
		db.execSQL("drop table if exists " + TABLE_CADEAU + ";");
		db.execSQL("drop table if exists " + TABLE_CADEAU_CONTACT + ";");
		db.execSQL(CREATE_TABLE_CLIENT);
		db.execSQL(CREATE_TABLE_CONTACT_CLIENT);
		db.execSQL(CREATE_TABLE_CADEAU);
		db.execSQL(CREATE_TABLE_CADEAU_CONTACT);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w(MaBaseSQLite.class.getName(),
		        "Upgrading database from version " + oldVersion + " to "
		            + newVersion + ", which will destroy all old data");
		    db.execSQL("DROP TABLE IF EXISTS " + TABLE_CLIENT + ";");
		    db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACT_CLIENT + ";");
		    db.execSQL("DROP TABLE IF EXISTS " + TABLE_CADEAU + ";");
		    db.execSQL("DROP TABLE IF EXISTS " + TABLE_CADEAU_CONTACT + ";");
		    onCreate(db);
	}
	
	

}
