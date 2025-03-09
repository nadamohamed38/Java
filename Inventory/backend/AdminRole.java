package backend;
import java.util.ArrayList;
import java.util.Arrays;

import constant.FileName;

public class AdminRole implements FileName {
	
	private EmployeeUserDatabase database = new EmployeeUserDatabase(EMPLOYEE_FILENAME ) ;
	
	public  AdminRole() {
	}
	
	public void addEmployee(String employeeId , String name , String email, String address , String phoneNumber ) {
		//database.readFromFile();
		EmployeeUser e = new EmployeeUser(employeeId, name, email, address, phoneNumber);
		database.insertRecord(e);
	}
	
	public EmployeeUser[] getListOfEmployees() {
		
		ArrayList<Inter> emp = database.returnAllRecords();
		EmployeeUser[] arr = emp.toArray(new EmployeeUser[emp.size()]);
			
		return arr;
	}
	
	public void removeEmployee(String key) {
		database.deleteRecord(key);
	}
	
	public void logout() {
		database.saveToFile(database.getFileName());
	}
	

}
