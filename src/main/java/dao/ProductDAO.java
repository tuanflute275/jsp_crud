package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import entity.Product;

public class ProductDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public List<Product> getAllProduct() {
		List<Product> list = new ArrayList<Product>();
		try {
			String sql = "SELECT * FROM product";
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getInt(4)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public void deleteProduct(String id) {
		try {
			String sql = "DELETE FROM `product` WHERE ID = ?";
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertProduct(String name, String price, String status) {
		try {
			String sql = "INSERT INTO `product`(`name`, `price`,`status`) VALUES (?,?,?)";
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, price);
			ps.setString(3, status);
			System.out.println(sql);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public Product getProductById(String id) {
		try {
			String sql = "SELECT * FROM `product` WHERE ID = ?";
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				return new Product(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getInt(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void updateProduct(String id, String name, String price, String status) {
		try {
			String sql = "UPDATE `product` SET `name`=?,`price`=?,`status`=? WHERE id=?";
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, price);
			ps.setString(3, status);
			ps.setString(4, id);
			System.out.println(sql);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int count(String txtSearch) {
		List<Product> list = new ArrayList<Product>();
		try {
			String sql = "SELECT count(*) FROM product where name like ?";
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1,"%" + txtSearch + "%");
			rs = ps.executeQuery();
			while(rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int countPage() {
		try {
			String sql = "SELECT count(*) FROM product";
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public List<Product> search(String txtSearch) {
		List<Product> list = new ArrayList<Product>();
		try {
			String sql = "SELECT * FROM product where name like ?";
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1,"%" + txtSearch + "%");
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getInt(4)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}
