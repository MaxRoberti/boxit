package com.boxit;



import com.boxit.core.Client;
import com.boxit.data.DataControl;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends Activity {
	
	private DataControl dataControl;

	
	private Button loginButton;
    private EditText loginMail;
    private EditText loginPassword;
    private Button signUpButton;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        
        // Cr��ation de la vue et lien avec interface
        setContentView(R.layout.activity_login);
        loginButton = (Button)findViewById(R.id.login_loginButton);
        loginMail = (EditText)findViewById(R.id.login_email);
        loginPassword = (EditText)findViewById(R.id.login_password);
        loginButton.setOnClickListener(new OnLoginBtnClickListener());
        signUpButton = (Button)findViewById(R.id.login_signupButton);
        signUpButton.setOnClickListener(new OnSignUpBtnClickListener());
        
		//Création d'une instance de ma classe DataControl
        dataControl = new DataControl(this);
        dataControl.open();
        
      //TODO test à enlever 
        Client client = new Client("maxrob","Roberti","Maximilien", "1993-04-02","0476723793","maximilienroberti@hotmail.com",
        		"123");

      //On insère le livre que l'on vient de créer
        if(!(dataControl.existsClientWithPseudo(client.getPseudo())))
        {
        	dataControl.insertClient(client);
        }
        
    }
	
	/*
	 * ActionListener pour le bouton de login : !!! Temporaire : Tests
	 */
	private class OnLoginBtnClickListener implements View.OnClickListener {
		
		public void onClick(View v) {
			
			boolean result = dataControl.logIn(loginMail.getText().toString(), loginPassword.getText().toString());
            if(result)
            {
            	Intent i = new Intent(LoginActivity.this, TestActivity.class);;
				//i.putExtra(Utilitaire.ROLE, VilleListActivity.ROLE_TOUTES_VILLES);
				startActivity(i);
            }
            else 
            	Toast.makeText(v.getContext(), "Utilisateur inconnu", Toast.LENGTH_SHORT).show();
        }
	}
	
	/*
	 * TODO : ActionListener pour le bouton SignUp
	 */
	private class OnSignUpBtnClickListener implements View.OnClickListener
	{
		public void onClick(View v) {
			Intent i = new Intent(LoginActivity.this, InscriptionActivity.class);
			startActivity(i);
		}
	}
	
	@Override
	  protected void onResume() {
	    dataControl.open();
	    super.onResume();
	  }

	  @Override
	  protected void onPause() {
	    dataControl.close();
	    super.onPause();
	  }
    
}
