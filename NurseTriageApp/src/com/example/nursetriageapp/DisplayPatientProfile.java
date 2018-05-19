package com.example.nursetriageapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DisplayPatientProfile extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_patient_profile);
		
		// Get the intent that started.
		Intent intent =  getIntent();
		int uhip = intent.getIntExtra("the uhip number", 0);
		
		
		// Display the value to the screen.
		TextView displayuhip = (TextView) findViewById(R.id.patientuhiptextView);
		displayuhip.setText("" + uhip);
		
		setupcheckpatienthistorybutton();
		setupnewhistorybutton();
		setupupdatebutton();
	}

	private void setupcheckpatienthistorybutton() {
		Button check =  (Button)findViewById(R.id.patientmedicalhistorybutton);
		check.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(DisplayPatientProfile.this, PatientMedicalHistory.class);
				startActivity(intent); 	
			}
			
		});
		
	}

	private void setupupdatebutton() {
		Button update =  (Button)findViewById(R.id.updatebutton);
		update.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(DisplayPatientProfile.this, Updatehistory.class);
				startActivity(intent); 	
			}
		});
		
	}

	private void setupnewhistorybutton() {
		Button addnew =  (Button)findViewById(R.id.createhistorybutton);
		addnew.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(DisplayPatientProfile.this, AddNewPatientHistory.class);
				startActivity(intent); 	
			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_patient_profile, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
