package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EditUserDao;

/**
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private EditUserDao editUserDao;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserServlet() {
    	 this.editUserDao = new EditUserDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String dob=request.getParameter("dob");
		String gender=request.getParameter("gender");
		String contact=request.getParameter("contact");
		String type=request.getParameter("type");
		
		boolean updated=editUserDao.updateUser(firstName, lastName, password, email, dob, gender, contact, type, username);
		
		if(updated) {
			 request.setAttribute("Message","User updated");
			 request.getRequestDispatcher("admin.jsp").forward(request, response);
		}
		else {
			 request.setAttribute("errorMessage","User not updated");
			 request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
