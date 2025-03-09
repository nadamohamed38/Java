package backend;

class EmployeeUserDatabase  extends DataBase{
	 
	private String fileName;

 	
	 public EmployeeUserDatabase(String fName) {
		 fileName = fName;
		 this.readFromFile();
	 }
	 public String getFileName() {
			return fileName;
		}
	
	 public void readFromFile() {
		 super.readFromFile(this.fileName);
	 }

	 
	 public EmployeeUser createRecordFrom(String line) {
		 
		 String[] s = new String[5];
		 s =  line.split(",",5);
		 EmployeeUser e = new EmployeeUser(s[0], s[1], s[2], s[3], s[4]);
		 return e;
	 }
	
}
