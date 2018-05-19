package com.example.nursetriageapp;


import backend.RecordManager;

import com.example.nursetriageapp.R;
import com.example.nursetriageapp.R.id;
import com.example.nursetriageapp.R.layout;
import com.example.nursetriageapp.R.menu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		setuploadpatientprofilebutton();
		setuploadpatientlistbutton();
		
	}

	private void setuploadpatientprofilebutton() {
		
		Button loadprofile =  (Button)findViewById(R.id.lookupbutton);
		loadprofile.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				EditText patientuhip = (EditText) findViewById(R.id.enteruhipeditText); 
				String uhip = patientuhip.getText().toString();
				int useruhip = Integer.parseInt(uhip);
				
				Intent intent = new Intent(MainActivity.this, DisplayPatientProfile.class);
				intent.putExtra("the uhip number", useruhip);
				
				startActivity(intent); 
			}
		});
	}
	
	private void setuploadpatientlistbutton() {
		
		Button loadlist =  (Button)findViewById(R.id.loadpatientlistbutton);
		loadlist.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View ve) {
				Intent intent = new Intent(MainActivity.this, DisplayPatientList.class);
				startActivity(intent); 
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
	
//	public void registerPerson(View view) {
//		Intent intent = new Intent(this, ListOfPatientInfoActivity.class);
//		
//		startActivity(intent);
//		
//	}
	
	public void hadLoadProfile(View view) {
		RecordManager.setDidLoadFile(true);
	}
	

}
