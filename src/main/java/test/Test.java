package test;

import java.util.List;

import dao.ProductDAO;
import entity.Product;

public class Test {
	public static void main(String[] args) {
		ProductDAO dao = new ProductDAO();
		List<Product> list = dao.getAllProduct();
//		for (Product product : list) {
//			System.out.println(product);
//		}
		int count = dao.count("ao");
		System.out.println(count);
		
		System.out.println(dao.search("tui"));;
	}
}
