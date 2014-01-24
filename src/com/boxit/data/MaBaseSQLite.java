package com.boxit.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MaBaseSQLite extends SQLiteOpenHelper{
	
	public static final String TABLE_CLIENT = "Client";
	public static final String COL_PSEUDO = "pseudo";
	public static final String COL_NOM = "nom";
	public static final String COL_PRENOM = "prenom";
	public static final String COL_DATE_NAISSANCE ="dateNaissance";
	public static final String COL_TEL = "tel";
	public static final String COL_MAIL = "mail";
	public static final String COL_PASSWORD = "password";

	
	
	private static final int VERSION_BDD = 1;
	private static final String NOM_BDD = "boxit.db";

	
	private static final String CREATE_BDD = " create table " + TABLE_CLIENT + "("
			+COL_PSEUDO+ " text primary key not null unique , " +COL_NOM+ " text not null , "
			+COL_PRENOM+ " text not null , "+COL_DATE_NAISSANCE+ " text not null , "
			+COL_TEL+ " text not null , "+COL_MAIL+ " text not null , "
			+COL_PASSWORD+" text not null);";
	
	
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
		//on créé la table à partir de la requête écrite dans la variable CREATE_BDD
		db.execSQL("drop table if exists " + TABLE_CLIENT + ";");
		db.execSQL(CREATE_BDD);		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w(MaBaseSQLite.class.getName(),
		        "Upgrading database from version " + oldVersion + " to "
		            + newVersion + ", which will destroy all old data");
		    db.execSQL("DROP TABLE IF EXISTS " + TABLE_CLIENT + ";");
		    onCreate(db);
	}
	
	

}
