package javadb;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.*;

/**
 * 
 * @author CBoom (cboom.trf@gmail.com)
 *
 */
public class OrderlineDAO {
	
	private DBaccess db;

	public OrderlineDAO(DBaccess db) {
		super();
		this.db = db;
	}
	
	public void storeOrderline(Orderline orderline) {
		String sql = "insert into Bestelregel(bestelnr, "
				+ "artikelcode, aantal) values(?,?,?);";
		try {
			PreparedStatement ps = db.getStatement(sql);
			ps.setInt(1, orderline.getOrder().getOrderId());
			ps.setString(2, orderline.getProduct().getProductId());
			ps.setInt(3, orderline.getAmount());
			db.executeUpdatePreparedStatement(ps);
		} catch (SQLException e) {
			System.out.println("SQL error " + e.getMessage());
		}
	}
	
}
