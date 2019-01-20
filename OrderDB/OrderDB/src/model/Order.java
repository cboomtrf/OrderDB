package model;

import java.util.*;

/**
 * 
 * @author CBoom (cboom.trf@gmail.com)
 *
 */
public class Order {

	//vars
	private int orderId;
	private java.util.Date orderUtilDate;
	private Customer customer;
	private ArrayList<Orderline> orderlines;
	private double totalPriceOrder;
	
	//constr
	public Order(Customer customer, java.util.Date orderDate) {
		this.customer = customer;
		this.orderUtilDate = orderDate;
		this.orderlines = new ArrayList<Orderline>();
	}
	
	//constr
	public Order(int orderId, Customer customer, java.util.Date orderUtilDate) {
		this.orderId = orderId;
		this.customer = customer;
		this.orderUtilDate = orderUtilDate;
		this.orderlines = new ArrayList<Orderline>();
	}

	public void addOrderline(Orderline orderline) {
		this.orderlines.add(orderline);
	}
	
	public String toString() {
		return "Bestelling van: \n" + this.customer 
				+ "op datum: " + this.orderUtilDate 
				+ "bevat de volgende items: \n" 
				+ this.sortedOrderlines(orderlines);
	}
	
	public String sortedOrderlines(ArrayList<Orderline> orderlines) {
		StringBuilder sortedOrderlines = new StringBuilder();
		orderlines.sort(null);
		
		for (int p = 0; p < this.orderlines.size(); p++) {
			sortedOrderlines.append(this.orderlines.get(p));
			sortedOrderlines.append("\n");
		}
		return sortedOrderlines.toString();
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Orderline> getOrderlines() {
		return orderlines;
	}

	public void setOrderlines(ArrayList<Orderline> orderlines) {
		this.orderlines = orderlines;
	}

	public double getTotalPriceOrder() {
		return totalPriceOrder;
	}

	public void setTotalPriceOrder(ArrayList<Orderline> orderlines) {
		for (Orderline o : orderlines) {
			this.totalPriceOrder += o.getTotalPriceOrderline();
		}
	}

	public java.util.Date getOrderUtilDate() {
		return orderUtilDate;
	}

	public void setOrderUtilDate(java.util.Date orderUtilDate) {
		this.orderUtilDate = orderUtilDate;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

}
