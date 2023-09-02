package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/AdminAddUserServlet")
public class AdminAddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDao userDao;
    @SuppressWarnings("unused")
	private boolean usernameExits;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAddUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init(){
    	userDao=new UserDao();
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
		LocalDate currentDate = LocalDate.now();
        String joinedDate = currentDate.toString();
		
		User user = new User();
		user.setfName(firstName);
		user.setlName(lastName);
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setDob(dob);
		user.setGender(gender);
		user.setContact(contact);
		user.setType(type);
		user.setJoinedDate(joinedDate);
		
		
		try {
			
			 usernameExits=userDao.usernameCheck(user.getUsername());
			 if(usernameExits=true) {
				userDao.registration(user);
				request.setAttribute("Message","User Added");
				 request.getRequestDispatcher("admin.jsp").forward(request, response);
			 }
			 else {
				 request.setAttribute("errorMessage","Username Already exist");
				 request.getRequestDispatcher("error.jsp").forward(request, response);
			 }
			
	        } catch (Exception e) {
	           
	            e.printStackTrace();
	        }

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
