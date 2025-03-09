package backend;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

 abstract class DataBase {
	
	private ArrayList<Inter> newRecords=new ArrayList<Inter>(); // array list its type interface(employeeuser , prod , custmorproduct)
    private String fileName ;
  
    public void readFromFile(String fn) //reading from file
    {
    	fileName = fn ;
    	try(Scanner f1=new Scanner(new File(fileName)) )
    {
    	
    		while(f1.hasNext())
    {
    			String line=f1.nextLine();
                newRecords.add(createRecordFrom(line));
    }
    } catch(IOException p){ 
    	System.out.println("An error occurred");
        }
    }
    
    public void saveToFile(String fn) //saving file
    {
    	fileName = fn ;
        try(PrintWriter pw=new PrintWriter(new File(fileName))){
        	
            for (int i=0;i<newRecords.size();i++)
            {
            		Inter e = this.getRecord( newRecords.get(i).getSearchKey());
            		
            			pw.println(e.lineRepresentation());
            	}
            
            }catch (IOException p) {
            System.out.println("An Error occurred");
        }
}
    
    
    public boolean contains(String key)
    {
        for(int i=0;i<newRecords.size();i++)
        {
            if(key.equalsIgnoreCase(newRecords.get(i).getSearchKey())==true) { //ignorecase : if the same letter but one uppercase and one lowercase returns true
                return true;
            }
        }
        return false;
    }
    
        
    
    public ArrayList<Inter> returnAllRecords()
    {
    	
        return newRecords;
    }
    public abstract Inter createRecordFrom(String line);
    
    public void insertRecord(Inter record)
    {
        newRecords.add(record);
    }
    
    public void deleteRecord(String key)
    {
    	for(int i=0;i<newRecords.size();i++)
    {
    		if(key.equals(newRecords.get(i).getSearchKey())==true)
    			newRecords.remove(i);
    }

}
    public Inter getRecord(String key)
    {
        for(int i=0;i<newRecords.size();i++)
        {
        	Inter e = newRecords.get(i);
            if(key.equals(e.getSearchKey())==true)
                return newRecords.get(i);
        }
        return null;
    }
}
