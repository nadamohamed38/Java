package backend;

import java.time.LocalDate;
 class CustomerProductDatabase  extends DataBase{

    private String fileName;

    public CustomerProductDatabase(String fileName) {
    	
        this.fileName = fileName;
        this.readFromFile();
    }
    public String getFileName() {
		return fileName;
	}
    
    public void readFromFile() {
		 super.readFromFile(fileName);
	 }
   

    
    public CustomerProduct createRecordFrom(String line)
    {
        String []s1= (line.split(",",3));
        String []strdate = s1[2].split("-",3); 
        LocalDate date = LocalDate.of(Integer.parseInt(strdate[2]),Integer.parseInt(strdate[1]),Integer.parseInt(strdate[0]));
        CustomerProduct p =new CustomerProduct(s1[0],s1[1],date);
        return p;
    }

    
}
	


