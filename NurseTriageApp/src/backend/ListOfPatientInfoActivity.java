package backend;

import com.example.nursetriageapp.R;
import com.example.nursetriageapp.R.id;
import com.example.nursetriageapp.R.layout;
import com.example.nursetriageapp.R.menu;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/*
 * TODO: Set the string array so it is to be read from the actual file using RecordManager.java
 * Will do later.
 * 
 */
public class ListOfPatientInfoActivity extends Activity {
	
	private String[] patientDataArray;
	
	private ArrayAdapter<String> itemsAdapter;
	
	private ListView list_of_patient_info;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.list_of_patient_info);
		
		// Set up the array of patient data
		patientDataArray = new String[10];
		
		// Populate the patientDataArray
		for(int i = 0; i < patientDataArray.length; i++){
			patientDataArray[i] = "Example Patient " + i;
		}
		
		// Initialize UI
		list_of_patient_info = (ListView) findViewById(R.id.list_of_patient_info);
		
		// Initialize the Array of strings to be placed in patient_info layout
		itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, patientDataArray);
		list_of_patient_info.setAdapter(itemsAdapter);
		
	}

	@Override
		public boolean onCreateOptionsMenu(Menu menu) {
	// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.list_of_patient_info, menu);
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
