package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import entity.Product;

@WebServlet(urlPatterns = { "/product" })
public class ProductControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductDAO dao = new ProductDAO();
		List<Product> list = dao.getAllProduct();
		
//		int count = dao.countPage();
//		int pageSize = 3;
//		int endPage = 0;
//		endPage = count / pageSize;
//		if(count % pageSize  != 0) {
//			endPage++;
//		}
//		req.setAttribute("endPage", endPage);
		
		req.setAttribute("listS", list);
		req.getRequestDispatcher("list.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			ProductDAO dao = new ProductDAO();
			String nameSearch = req.getParameter("search");
			List<Product> list = dao.search(nameSearch);
			
//			int count = dao.count(nameSearch);
//			int pageSize = 3;
//			int endPage = 0;
//			endPage = count / pageSize;
//			if(count % pageSize  != 0) {
//				endPage++;
//			}
//			req.setAttribute("endPage", endPage);
			
			req.setAttribute("listS", list);
			req.getRequestDispatcher("list.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
