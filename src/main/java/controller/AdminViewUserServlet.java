package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminViewUserDao;
import model.User;

/**
 * Servlet implementation class AdminViewUserServlet
 */
@WebServlet("/AdminViewUserServlet")
public class AdminViewUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminViewUserDao adminViewUserDao;
    
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminViewUserServlet() {
        this.adminViewUserDao=new AdminViewUserDao();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		System.out.println(type);
		ArrayList<User> users = adminViewUserDao.getUsersByType(type);
		System.out.println(users.get(0).getfName());
        request.setAttribute("users", users);
        request.getRequestDispatcher("admin.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
}
