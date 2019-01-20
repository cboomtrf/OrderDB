package javadb;

import java.sql.*;
import java.util.*;

import model.*;

/**
 * 
 * @author CBoom (cboom.trf@gmail.com)
 *
 */
public class OrderDAO {
	
	private DBaccess db;
	private CustomerDAO customerDAO = new CustomerDAO(db);

	public OrderDAO(DBaccess db) {
		super();
		this.db = db;
	}
	
	public void storeOrder(Order order) {
		String sql = "insert into Bestelling(klantnr, "
				+ "besteldatum) values(?,?);";
		try {
			PreparedStatement ps = db.getStatementWithKey(sql);
			ps.setInt(1, order.getCustomer().getCustomerId());
			java.sql.Date orderSqlDate = new java.sql.Date(order.getOrderUtilDate().getTime());
			ps.setDate(2, orderSqlDate);
			int generatedKey = db.executeInsertPreparedStatement(ps);
			order.setOrderId(generatedKey);
			System.out.println(order + " inserted. "
					+ "OrderID set to: " + generatedKey);
		} catch (SQLException e) {
			System.out.println("SQL error " + e.getMessage());
		}
	}
	
	public Order getOrderByOrderId(int bestelnr) {
		String sql = "Select * from Bestelling where bestelnr = ?;";
		Order result = null;
		try {
			PreparedStatement ps = db.getStatement(sql);
			ps.setInt(1, bestelnr);
			ResultSet rs = db.executeSelectPreparedStatement(ps);
			
			while (rs.next()) {
				int orderId = rs.getInt("bestelnr");
				int customerId = rs.getInt("klantnr");
				java.sql.Date orderSqlDate = rs.getDate("besteldatum");
				
				java.util.Date orderUtilDate = new java.util.Date(orderSqlDate.getTime());
				
				Customer customer = customerDAO.getCustomerByID(customerId);
				result = new Order(orderId, customer, orderUtilDate);
			}
		} catch (SQLException e) {
			System.out.println("SQL error " + e.getMessage());
		}
		return result;
	}
	
	public List<Order> getOrderByCustomerId(int custId) { 
		String sql = "Select * from Bestelling where klantnr = ?;";
		
		List<Order> result = new ArrayList<Order>();
		try {
			PreparedStatement ps = db.getStatement(sql);
			ps.setInt(1, custId);
			ResultSet rs = db.executeSelectPreparedStatement(ps);
			
			while (rs.next()) {
				int orderId = rs.getInt("bestelnr");
				int customerId = rs.getInt("klantnr");
				java.sql.Date orderSqlDate = rs.getDate("besteldatum");
				
				java.util.Date orderUtilDate = new java.util.Date(orderSqlDate.getTime());

				Customer customer = customerDAO.getCustomerByID(customerId);
				Order resultElement = 
						new Order(orderId, customer, orderUtilDate);
				result.add(resultElement);
			}
		} catch (SQLException e) {
			System.out.println("SQL error " + e.getMessage());
			}
			return result;
		}

}
