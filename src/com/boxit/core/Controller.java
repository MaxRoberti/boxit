package com.boxit.core;





import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

public class Controller extends SQLiteOpenHelper
{

	public static final String DATABASE_NAME = "boxit.db";
	public static final int DATABASE_VERSION = 1;

	private static Controller control;

	private Client currentClient;

	private Context appContext;

	/* CONTRUCTEUR ET METHODE
	 ****************************** 
	 */
	/**
	 * Constructeur
	 * @param context
	 */
	private Controller(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		this.appContext = context;
	}

	public Client getCurrentClient() {
		return currentClient;
	}

	public void setCurrentClient(Client currentClient) {
		this.currentClient = currentClient;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

	/* METHODES SUR LE LOGIN
	 ****************************** 
	 */
	/**
	 * @param email
	 * @param password
	 * @return True si le user a r��ussi �� se connecter
	 */
	
	
	



}
