package controller;

import java.util.*;

import javadb.*;
import model.*;

/**
 * 
 * @author CBoom (cboom.trf@gmail.com)
 *
 */
public class Main {

	private DBaccess db;
	private ProductDAO pdao;
	private CustomerDAO cdao;
	
	public Main() {
		super();
		db = new DBaccess();
		pdao = new ProductDAO(db);
		cdao = new CustomerDAO(db);
	}

	public static void main(String[] args) {
		Main myself = new Main();
		myself.run();
	}

	private void run() {
	
		try {
			db.openConnection();
			System.out.println("Connection open");
		} 
		catch (Exception e) {
			System.out.println("\nEr is iets fout gegaan\n");
			e.printStackTrace();
		}
		
//		Customer carina = new Customer("Carina", "Deventer");
//		cdao.storeCustomer(carina);
		
		int custId = 3;
		Customer customer = cdao.getCustomerByID(custId);
		if (customer == null) {
				System.out.println("Customer with customerId " + custId + " does not exist");
			}
		else {
			System.out.println("The customer with customerId " + custId + " is: \n" + customer);
		}
		
		System.out.println();
		
		List<Customer> custCity = cdao.getCustomerByCity("Deventer");
		for (Customer c : custCity) {
			System.out.println(c);
		}
		
		System.out.println();

//		Product tv = new Product("A9","Sony A6300", "hoog", 1099.99, 6);
//		pdao.storeProduct(tv);
		
		String prodId = "A9";
		Product product = pdao.getProductByID(prodId);
		if (product == null) {
				System.out.println("Product with productId " + prodId + " does not exist");
			}
		else {
			System.out.println("The product for productId " + prodId + " is: \n" + product);
		}
		
		System.out.println();
		
		List<Product> productLaag = pdao.getProductByTaxgroup("laag");
		for (Product p : productLaag) {
			System.out.println(p);
		}
		
		List<Product> productHoog = pdao.getProductByTaxgroup("hoog");
		for (Product p : productHoog) {
			System.out.println(p);
		}
		
		db.closeConnection();

	}
}
