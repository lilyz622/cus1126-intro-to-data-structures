class Patient {
	int patientID;
	String fullName;
	String Disease;
	String Gender;
	int doctorID;
	int clinicID;
	
	// link to next node
	Patient next;
	
	public Patient(int patientID, String fullName, String disease, String gender, int doctorID, int clinicID) {
		super();
		this.patientID = patientID;
		this.fullName = fullName;
		Disease = disease;
		Gender = gender;
		this.doctorID = doctorID;
		this.clinicID = clinicID;
	}
	
	public String toString(){
		return "Patient ID:"+patientID+"\tName:"+fullName+"\tDisease:"+Disease
				+"\tDoctor ID:"+doctorID+"\tClinic ID:"+clinicID;
	}
}