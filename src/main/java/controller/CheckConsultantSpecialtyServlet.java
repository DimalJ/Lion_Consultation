package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.AddAppointmentSpecialtyDao;
//import model.Appointment;
import model.User;

/**
 * Servlet implementation class CheckConsultantSpecialtyServlet
 */
@WebServlet("/CheckConsultantSpecialtyServlet")
public class CheckConsultantSpecialtyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AddAppointmentSpecialtyDao addAppointmentSpecialtyDao;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckConsultantSpecialtyServlet() {
        super();
       this.addAppointmentSpecialtyDao = new AddAppointmentSpecialtyDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	 	String industry = request.getParameter("industry");
        String region = request.getParameter("region");
        List<User> availableConsultants = addAppointmentSpecialtyDao.getAvailableConsultants(industry, region);
        request.setAttribute("availableConsultants", availableConsultants);
        RequestDispatcher dispatcher = request.getRequestDispatcher("searchConsultant.jsp");
        dispatcher.forward(request, response);
      
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
