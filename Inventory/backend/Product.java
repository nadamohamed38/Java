package backend;

public class Product implements Inter {
	
	 private String productId;
	    private String productName;
	    private String manufacturerName;
	    private String supplierName;
	    private int quantity;
	    private float price;

	    public Product(String productId,String productName,String manufacturerName,String supplierName,int quantity,float price) {
	        this.productId = productId;
	        this.productName = productName;
	        this.manufacturerName = manufacturerName;
	        this.supplierName = supplierName;
	        this.quantity = quantity;
	        this.price = price;

	    }

	    public String getProductID() {
	        return productId;
	    }

	    public void setProductId(String productId) {
	        this.productId = productId;
	    }

	    public String getProductName() {
	        return productName;
	    }

	    public void setProductName(String productName) {
	        this.productName = productName;
	    }

	    public String getManufacturerName() {
	        return manufacturerName;
	    }

	    public void setManufacturerName(String manufacturerName) {
	        this.manufacturerName = manufacturerName;
	    }

	    public String getSupplierName() {
	        return supplierName;
	    }

	    public void setSupplierName(String supplierName) {
	        this.supplierName = supplierName;
	    }

	    public float getPrice() {
	        return price;
	    }

	    public void setPrice(float price) {
	        this.price = price;
	    }

	    public int getQuantity() {
	        return quantity;
	    }

	    public void setQuantity(int quantity) {
	        this.quantity = quantity;
	    }
	    public String lineRepresentation()
	    {
	        return this.productId+","+this.productName+","+this.manufacturerName+","+this.supplierName+","+this.quantity+","+this.price;
	    }
	    public String getSearchKey()
	    {
	        return this.getProductID();
	    }

}
