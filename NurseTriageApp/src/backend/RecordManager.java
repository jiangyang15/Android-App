package backend;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;


import android.content.Context;

public class RecordManager {
	/** Usage:
	 * RecordManager manager = RecordManager.getInstance(getApplicationContext());
        ArrayList<Patient> list = manager.getPatientRecords();
        RecordManager manager = RecordManager.getinstance();
	 */
	private static RecordManager instance;
	private static Context context;
	private static boolean didLoadFile = false;   // Use this boolean attributes for whether or not the user has loaded existing file. If not, return an empty arraylist.
	private ArrayList <Patient> patientRecordList;
	private HashMap<Integer,String> visitRecordList;
	
	private RecordManager(){
		patientRecordList = initializePatientRecords();
		visitRecordList = intitializeVisitRecordList();
	}
	
	public static RecordManager getInstance(Context ctx) {
		if(instance == null){
			context = ctx;
			instance = new RecordManager();
		}
		return instance;
	}
	
	// Read file methods that returns an ArrayList of patienrRecords
	private ArrayList<Patient> initializePatientRecords(){
		/**
		 *Load data from existing patient_records.txt and read it line by line. Store
		 *each patient's info into Patient objects.
		 *Construct an ArrayList of Patient objects with info loaded. 
		 */
		ArrayList <Patient> list = new ArrayList<Patient>();
		String line;
		FileInputStream fileByte = null;
		BufferedReader reader = null;
		try {
			String fileName = "patient_records.txt";
			File patientFile = context.getFileStreamPath(fileName);
			if(patientFile.exists()){
				try{
					fileByte = new FileInputStream(patientFile);
		
					reader = new BufferedReader(new InputStreamReader(fileByte));
					line = reader.readLine();
					while (line != null){
						// Process the patient_record.txt line by line
						// pass in i.e. "324231,Jie Wu,1992-10-12"
						Patient patient = new Patient(line); 
						list.add(patient);
						line = reader.readLine();
					}
				}catch(FileNotFoundException e){
					e.printStackTrace();
				} finally {
					if (fileByte != null){
						fileByte.close();
					}
					reader.close();
				}
			}
		} catch (IOException e){
			System.out.println(e);
			return null;
		}
		return list;
	}
	
	// Write File methods that wrties the Patient information in the visit_records.txt.
	public ArrayList<Patient> getPatientRecords() {
		return patientRecordList;
	}
	
	// Method to initialize visitRecords 
	// EITHER get visit_records.txt if it exists or create it for the first time 
	// if it doesn't
	public HashMap<Integer,String> intitializeVisitRecordList(){
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		
		// Get files directory (NOT ASSETS)
		String filename = "visit_records.txt";
		File file = context.getFileStreamPath(filename);
		
		if(file.exists()) {
			// If file exists then return a hashmap of current content
			try {
				FileInputStream in = new FileInputStream(file);
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			// If file does not exist, make a new file and initialize contents
			try {
				FileOutputStream out = new FileOutputStream(file);
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		// If file does not exist then create it
		
		// Else read the file 
		
		// As you read, store within Hashmap the file contents
		
		// Finally assign map and return it
		visitRecordList = map;
		return map;
		
	}
	
	
	// Method to add to visitrecords.txt and list
	
	
	// Method to get visitrecordslist as an object
	
	// Getters and setters
	public static boolean isDidLoadFile() {
		return didLoadFile;
	}

	public static void setDidLoadFile(boolean didLoadFile) {
		RecordManager.didLoadFile = didLoadFile;
	}
	
}
