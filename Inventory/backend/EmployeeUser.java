package backend;

public class  EmployeeUser implements Inter {
	
	private String employeeId ;
	private String employeeName ;
	private String employeeEmail ;
	private String employeeAddress;
	private String employeePhNum;
	 
	public EmployeeUser(String id , String name , String email , String addrs , String phnNum) {
		
		employeeName = name;
		employeeId = id;
		employeeEmail = email;
		employeeAddress = addrs;
		employeePhNum = phnNum;
	}
	
	public void setEmployeeId(String id) {
		employeeId = id;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	
	public void setEmployeeName(String name) {
		employeeName = name;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	
    public void setEmployeeEmail(String email) {
		employeeEmail = email;
	}
	public String getemployeeEmail() {
		return employeeEmail;
	}
	
	public void setEmployeeAddress(String add) {
		employeeAddress = add;
	}
	public String getemployeeAddress() {
		return employeeAddress;
	}
	
	public void setEmployeePhNum(String num) {
		employeePhNum = num;
	}
	public String getEmployeePhNum() {
		return employeePhNum;
	}
	
	@Override
	public String lineRepresentation() {
		 return this.employeeId+","+this.employeeName+","+this.employeeEmail+","+this.employeeAddress+","+this.employeePhNum;
		
	}
	@Override 
	public String getSearchKey() {
		return this.getEmployeeId();
	}

	
	

}
