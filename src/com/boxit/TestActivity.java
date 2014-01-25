
package com.boxit;



import com.boxit.core.Client;
import com.boxit.data.DataControl;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

import android.widget.TextView;

public class TestActivity extends Activity {
	TextView textTest = null;
	TextView textTest2 = null;
	private DataControl dataControl;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test);
		
		
		
		//Création d'une instance de ma classe LivresBDD
        dataControl = new DataControl(this);
        
        //TODO test à enlever 
        Client client = new Client("maxrob","Roberti","Maximilien", "1993-04-02","0476723793","maximilienroberti@hotmail.com",
        		"123");

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
    	
    	dataControl.insertContact("Lhonard","maxrob");
        
       
		//test
        String result = clientFromBDD.getMail();
        String result2;
        if(dataControl.alreadyContact("Lhonard","maxrob")) {
        	result2= "d�j� pote";
        }
        else {
        	result2="pas encore potes";
        }
        
		//String result ="coucou";
		dataControl.close();
		// test client
		textTest = (TextView)findViewById(R.id.textVieuw1);
		textTest.setText(" ");
		// test contact
		textTest2 = (TextView)findViewById(R.id.textVieuw2);
		textTest2.setText(result2);
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


	
	
	
	
	
	
	
	
	
}

