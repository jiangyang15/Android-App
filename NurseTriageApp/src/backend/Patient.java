package backend;

public class Patient {
	private int ohipNumber;
	private String patientName;
	private String dateOfBirth;
	// pass in i.e. "324231,Jie Wu,1992-10-12"
	public Patient(String line) {
		String[] patientString = line.split(",");
		setOhipNumber(Integer.parseInt(patientString[0]));
		setPatientName(patientString[1]);
		setDateOfBirth(patientString[2]);
		
	}
	public int getOhipNumber() {
		return ohipNumber;
	}
	public void setOhipNumber(int ohipNumber) {
		this.ohipNumber = ohipNumber;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	

}
