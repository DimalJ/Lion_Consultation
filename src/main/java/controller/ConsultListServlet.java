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
 * Servlet implementation class ConsultListServlet
 */
@WebServlet("/ConsultListServlet")
public class ConsultListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AdminViewUserDao adminViewUserDao;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultListServlet() {
        super();
        this.adminViewUserDao = new AdminViewUserDao();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = "consultant";
		ArrayList<User> users = adminViewUserDao.getUsersByType(type);
        request.setAttribute("users", users);
        request.getRequestDispatcher("consultList.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
