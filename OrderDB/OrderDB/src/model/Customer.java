package model;

/**
 * 
 * @author CBoom (cboom.trf@gmail.com)
 *
 */
public class Customer {
	
	//vars
	private int customerId;
	private String customerName;
	private String city;
	
	public Customer(String customerName, String city) {
		super();
		this.customerName = customerName;
		this.city = city;
	}
	
	public Customer(int customerId, String customerName, String city) {
		super(); 
		this.customerId = customerId; //customerID can be set 
		this.customerName = customerName;
		this.city = city;
	}

	@Override
	public String toString() {
		return "Customer " + this.customerId
				+ " with name: " + this.customerName 
				+ " - City: " + this.city; 
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
