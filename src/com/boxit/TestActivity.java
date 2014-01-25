
package com.boxit;



import com.boxit.core.Client;
import com.boxit.core.Cadeau;

import com.boxit.data.DataControl;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

import android.widget.TextView;

public class TestActivity extends Activity {
	TextView textTest = null;
	TextView textTest2 = null;
	TextView textTest3 = null;

	private DataControl dataControl;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test);



		//Création d'une instance de ma classe LivresBDD
		dataControl = new DataControl(this);

		//TODO test à enlever 
		Client client = new Client("pseudo","Roberti","Maximilien", "1993-04-02","0476723793","maximilienroberti@hotmail.com","1");
		   
		//On ouvre la base de données pour écrire dedans
		dataControl.open();
		//On insère le livre que l'on vient de créer
		if(!(dataControl.existsClientWithPseudo(client.getPseudo())))
		{
			dataControl.insertClient(client);
		}



		//Pour vérifier que l'on a bien créé notre livre dans la BDD
		//on extrait le livre de la BDD grâce au titre du livre que l'on a créé précédemment
		Client clientFromBDD = dataControl.getClientWithPseudo(client.getPseudo());

		// Tests pour les contacts

		// on ins�re un client
		if(!dataControl.alreadyContact("Lhonard","maxrob")) {
		dataControl.insertContact("Lhonard","maxrob");
		}
	
		

		Cadeau cadeau1= new Cadeau("url5","lhonard", 1, 54.2, 52.5, "kikou enfoire", 100, "1993-10-22", "2014-05-22", "Tu veux ma photo ou quoi" );

		dataControl.insertCadeau(cadeau1);


		//test client
		String result = clientFromBDD.getMail();

		// test contact
		String result2;
		if(dataControl.alreadyContact("Lhonard","maxrob")) {
			result2= "d�j� pote";
		}
		else {
			result2="pas encore potes";
		}
		// test cadeau

		Cadeau essai = dataControl.getCadeauWithUrl("url5");
		String result3= essai.getLegende();

		//String result ="coucou";
		dataControl.close();
		// test client
		textTest = (TextView)findViewById(R.id.textVieuw1);
		textTest.setText(" ");
		// test contact
		textTest2 = (TextView)findViewById(R.id.textVieuw2);
		textTest2.setText(" ");
		// test Cadeau
		textTest3 = (TextView)findViewById(R.id.textVieuw3);
		textTest3.setText(result3);		

	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}



}

