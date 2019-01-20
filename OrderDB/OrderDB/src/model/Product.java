package model;

/**
 * 
 * @author CBoom (cboom.trf@gmail.com)
 *
 */
public class Product {
	
	private String productId; 
	private String productName;
	private String taxGroup;
	private double price;
	private int stockAmount;
	
	public Product(String productId, String productName, String taxGroup, double price, int stockAmount) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.taxGroup = taxGroup;
		this.price = price;
		this.stockAmount = stockAmount;
	}
	
	public String getProductId() {
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
	public String getTaxGroup() {
		return taxGroup;
	}
	public void setTaxGroup(String taxGroup) {
		this.taxGroup = taxGroup;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStockAmount() {
		return stockAmount;
	}
	public void setStockAmount(int stockAmount) {
		this.stockAmount = stockAmount;
	}
	
	public String toString() {
		return "[" + productId + ", " + productName + ", " + taxGroup + ", " + price + ", " + stockAmount + "]" ;
		
	}
}
