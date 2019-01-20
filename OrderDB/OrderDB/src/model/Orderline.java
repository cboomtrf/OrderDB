package model;

/**
 * 
 * @author CBoom (cboom.trf@gmail.com)
 *
 */
public class Orderline implements Comparable<Orderline>{

	//vars
	private int amount;
	private Order order;
	private Product product;
	private double totalPriceOrderline;
	
	//constr
	public Orderline(int amount, Order order, 
			Product product) {
		this.amount = amount;
		this.order = order;
		this.product = product;
	}
	
	public String toString() {
		return "- Product: " + this.product.getProductId() + 
				" (" + this.product.getProductName() + "), Amount: "
				+ this.amount + " (Ordernr: " + this.order.getOrderId() + ")";
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public double getTotalPriceOrderline() {
		return totalPriceOrderline;
	}
	
	public void setTotalPriceOrderline(Product product, Order order) {
		this.totalPriceOrderline = 
				(this.product.getPrice() * this.getAmount());
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public int compareTo(Orderline o) {
		if (this.product.getProductId() == null || this.amount == 0) {
			return -1;
		}
		return 1; 
	}
	
	
	
}
