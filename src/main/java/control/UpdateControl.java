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

@WebServlet(urlPatterns = {"/updateProduct"})
public class UpdateControl extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("pid");
		ProductDAO dao = new ProductDAO();
		Product pro = dao.getProductById(id);
		req.setAttribute("p", pro);
		req.getRequestDispatcher("update.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pid = req.getParameter("id");
		String pname = req.getParameter("name");
		String pprice = req.getParameter("price");
		String pstatus = req.getParameter("status");
		
		ProductDAO dao = new ProductDAO();
		dao.updateProduct(pid, pname, pprice, pstatus);
		resp.sendRedirect("product");
	}
}
