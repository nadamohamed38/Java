package backend;

class ProductDatabase extends DataBase{
	
    private String fileName;

    public ProductDatabase(String fileName) {
        this.fileName = fileName;
        this.readFromFile();
    }
    public String getFileName() {
		return fileName;
	}

    public void readFromFile() {
		 super.readFromFile(fileName);
	 }
    
    public Product createRecordFrom(String line) 
    {
        String []s1= new String[6];
        s1 = line.split(",",6);
        Product p=new Product(s1[0],s1[1],s1[2],s1[3],Integer.parseInt(s1[4]),Float.parseFloat(s1[5]));
        return p;
    }

}
