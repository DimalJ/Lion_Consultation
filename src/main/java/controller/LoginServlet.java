package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoginDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginDao loginDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init(){
    	loginDao=new LoginDao();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		boolean authenticated = loginDao.authenticate(username,password);
		if (authenticated==true) {
            String userType = loginDao.getUserType(username);
	         HttpSession session = request.getSession();
	         session.setAttribute("username", username);
	         session.setAttribute("userType", userType);
            if (userType != null) {
                if ("jobSeeker".equals(userType)) {
                    response.sendRedirect("jobSeeker.jsp");
                } else if ("consultant".equals(userType)) {
                    response.sendRedirect("consultants.jsp");
                } else if ("admin".equals(userType)) {
                    response.sendRedirect("admin.jsp");
                } else {
                    response.sendRedirect("error.jsp");
                }
            } else {
                response.sendRedirect("error.html");
            }
        } else {
            response.sendRedirect("admin.jsp");
        }
    }
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
