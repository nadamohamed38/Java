package backend;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class CustomerProduct implements Inter {
	
	private String customerSSN;
    private String productId;
    private LocalDate purchaseDate;

    public CustomerProduct(String customerSSN,String productId,LocalDate purchaseDate) {
        this.customerSSN=customerSSN;
        this.productId=productId;
        this.purchaseDate=purchaseDate;
    }

    public String getCustomerSSN() {
        return customerSSN;
    }

    public String getProductID() {
        return productId;
    }
    

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }
    public String lineRepresentation()
    {
    	DateTimeFormatter f = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        return this.customerSSN+","+this.productId+","+ this.purchaseDate.format(f);
    }
    public String getSearchKey()
    {
    	return this.customerSSN +","+this.productId+","+this.purchaseDate;
    }

}
