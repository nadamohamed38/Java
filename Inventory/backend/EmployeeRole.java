package backend;

import java.time.LocalDate;
import java.util.ArrayList;

import constant.FileName;


public class EmployeeRole implements FileName  {
	    private ProductDatabase productsDatabase = new ProductDatabase(PRODUCT_FILENAME);
	    private CustomerProductDatabase customerProductDatabase = new CustomerProductDatabase(CUSTOMERPRODUCT_FILENAME);

	    public EmployeeRole() {
	    }
	    public void addProduct(String productId,String productName,String manufacturerName,String supplierName,int quantity,float price)
	    {
	        Product p=new Product(productId , productName , manufacturerName , supplierName ,quantity,price);
	        productsDatabase.insertRecord(p);
	       

	    }
	    public Product[] getListOfProducts()
	    {
	        ArrayList<Inter> prod = productsDatabase.returnAllRecords();
	        Product[] arr = prod.toArray(new Product[prod.size()]);
	        return arr ;
	    }
	    public CustomerProduct[] getListOfPurchasingOperations()
	    {
	    	ArrayList<Inter> cusProd = customerProductDatabase.returnAllRecords();
	    	CustomerProduct[] arr = cusProd.toArray(new CustomerProduct[cusProd.size()]);
	    	return arr;
	    }
	    
	    public boolean purchaseProduct(String customerSSn, String productID, LocalDate purchaseDate)
	    {
	    	Product p = (Product) productsDatabase.getRecord(productID);
	    	if(productsDatabase.contains(productID) == true && p.getQuantity() == 0) //law product khalas 
	    		return false;
	    	else { // law lesa fe quantity 
	    		p.setQuantity(p.getQuantity()-1); // product file quantity -1 
	    		customerProductDatabase.insertRecord(new CustomerProduct(customerSSn, productID, purchaseDate)); //hazwed customer product
	    		customerProductDatabase.saveToFile(customerProductDatabase.getFileName()); //save file
	    		productsDatabase.saveToFile(productsDatabase.getFileName());//save file
	    		return true;
	    	}

	    }
	    public double returnProduct(String customerSnn,String productId,LocalDate purchaseDate,LocalDate returnDate)
	    {
	    	CustomerProduct c = new CustomerProduct(customerSnn, productId, purchaseDate);
	    	String key = c.getSearchKey();
	    	if(returnDate.isBefore(purchaseDate) == true) //return date before purchase date
	    		return -1;
	    	else if(productsDatabase.contains(productId) == false) // product in product file
	    		return -1;
	    	else if(returnDate.getDayOfYear() - purchaseDate.getDayOfYear() > 14) // he return the product after more than 14 days
	    		return -1;
	    	else if(customerProductDatabase.contains(key) == false) // product in cust prod file
	    		return -1;
	    	else {
	    		Product p = (Product) productsDatabase.getRecord(productId); 
	    		p.setQuantity(p.getQuantity() + 1); // hazwed quantity 1
	    		customerProductDatabase.deleteRecord(key); // delete this product mn cust prod file
	    		productsDatabase.saveToFile(productsDatabase.getFileName()); 
	    		return p.getPrice();
	    	}
	    	
	    	

	    }
	    
	    public void logout() {
	    	productsDatabase.saveToFile(productsDatabase.getFileName());
	    	customerProductDatabase.saveToFile(customerProductDatabase.getFileName());
	    }

}
