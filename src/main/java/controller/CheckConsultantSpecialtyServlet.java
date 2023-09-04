package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AddAppointmentSpecialtyDao;
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
		String action =request.getParameter("action");
	 	String industry = request.getParameter("industry");
        String region = request.getParameter("region");
      
	 	switch(action) {
	 	case "checkAvailability":
	 		 List<User> availableConsultants = addAppointmentSpecialtyDao.getAvailableConsultants(industry, region);
	 		 
	         request.setAttribute("availableConsultants", availableConsultants);
	         request.setAttribute("industry", industry);
	         request.setAttribute("region", region);

	         RequestDispatcher dispatcher = request.getRequestDispatcher("searchConsultant.jsp");
	         dispatcher.forward(request, response);
	         break;
	 	case "addAppointment":
	 		HttpSession session = request.getSession();
	        String seeker_username = (String) session.getAttribute("username");
	 		 String consult_username= request.getParameter("consultant");
	 		 /*boolean booked = addAppointmentDao.addAppointment(seeker_username, consult_username, appointmentDate, appointmentTime);
	         if (booked) {
	         	request.setAttribute("Message","Appointment added");
	 			request.getRequestDispatcher("jobSeeker.jsp").forward(request, response);
	         } else {
	         	request.setAttribute("Message","Appointment not added");
	 			request.getRequestDispatcher("addAppointment.jsp").forward(request, response);
	         }*/
	         break;
	 	default:
	 		request.setAttribute("errorMessage","Appointment not added");
 			request.getRequestDispatcher("error.jsp").forward(request, response);
 			break;
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
