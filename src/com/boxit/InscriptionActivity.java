package com.boxit;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.boxit.core.*;
import com.boxit.data.DataControl;

import android.widget.DatePicker;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InscriptionActivity extends Activity {

	private DataControl dataControl;

	private EditText email;
	private EditText password;
	private EditText confirm;
	private EditText name;
	private EditText firstname;
	private EditText pseudo;
	private DatePicker datedenaiss;
	private String date_de_naissance;
	private EditText telnumber;
	private Button signupBtn;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		;

		//Création d'une instance de ma classe DataControl
		dataControl = new DataControl(this);
		dataControl.open();

		setContentView(R.layout.activity_inscription);
		email = (EditText) findViewById(R.id.signup_email);
		password = (EditText) findViewById(R.id.signup_password);
		confirm = (EditText) findViewById(R.id.signup_confirm);
		name = (EditText) findViewById(R.id.signup_name);
		firstname = (EditText) findViewById(R.id.signup_firstname);
		pseudo = (EditText) findViewById(R.id.signup_pseudo);
		telnumber = (EditText) findViewById(R.id.signup_telnumber);
		signupBtn = (Button) findViewById(R.id.signup_signupbutton);

		datedenaiss = (DatePicker) findViewById(R.id.datePicker);
		date_de_naissance= Integer.toString(datedenaiss.getYear())+"-"+Integer.toString(datedenaiss.getDayOfMonth())+"-"+Integer.toString(datedenaiss.getMonth());


		signupBtn.setOnClickListener(new OnSignUpBtnClickListener(this));
	}

	/* LISTENER CLASS
	 ****************************** 
	 */
	/**
	 *
	 */

	public static boolean isEmailAddress(String email){
		Pattern p = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$");
		Matcher m = p.matcher(email);
		return m.matches();
	} 
	
	
	private class OnSignUpBtnClickListener implements View.OnClickListener {
		private InscriptionActivity toClose;

		public OnSignUpBtnClickListener(InscriptionActivity toClose) {
			this.toClose = toClose;
		}

		public void onClick(View v) {
			if(!isEmailAddress(email.getText().toString()))
				Toast.makeText(v.getContext(), getResources().getString(R.string.signup_error_email), Toast.LENGTH_SHORT).show();

			else if(!password.getText().toString().equals(confirm.getText().toString()))
				Toast.makeText(v.getContext(), getResources().getString(R.string.signup_error_password), Toast.LENGTH_SHORT).show();

			else if(firstname.getText().length() == 0 || name.getText().length() == 0|| pseudo.getText().length() == 0)
				Toast.makeText(v.getContext(), getResources().getString(R.string.signup_error_name), Toast.LENGTH_SHORT).show();
			else if(dataControl.existsClientWithPseudo(pseudo.getText().toString()) || dataControl.existsClientWithMail(email.getText().toString())
					|| dataControl.existsClientWithTel(telnumber.getText().toString()))
			Toast.makeText(v.getContext(), getResources().getString(R.string.signup_error_exists), Toast.LENGTH_SHORT).show();

			else  {
				Client client = new Client(pseudo.getText().toString(),name.getText().toString(), firstname.getText().toString(),date_de_naissance, telnumber.getText().toString(),email.getText().toString(), password.getText().toString());

				if(client != null) {
					dataControl.insertClient(client);
					Intent i = new Intent(InscriptionActivity.this, LoginActivity.class);
					startActivity(i);
				} 

				toClose.finish();

			}
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