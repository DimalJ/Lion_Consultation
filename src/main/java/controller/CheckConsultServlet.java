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

import dao.AddAppointmentDao;
import model.User;

/**
 * Servlet implementation class CheckConsultServlet
 */
@WebServlet("/CheckConsultServlet")
public class CheckConsultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AddAppointmentDao addAppointmentDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckConsultServlet() {
        this.addAppointmentDao=new AddAppointmentDao();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 	String action =request.getParameter("action");
		 	String appointmentDate = request.getParameter("appointmentDate");
	        String appointmentTime = request.getParameter("appointmentTime");
	      
		 	switch(action) {
		 	case "checkAvailability":
		 		 List<User> availableConsultants = addAppointmentDao.getAvailableConsultants(appointmentDate, appointmentTime);
		 		 
		         request.setAttribute("availableConsultants", availableConsultants);
		         request.setAttribute("time", appointmentTime);
		         request.setAttribute("date", appointmentDate);

		         RequestDispatcher dispatcher = request.getRequestDispatcher("addAppointment.jsp");
		         dispatcher.forward(request, response);
		         break;
		 	case "addAppointment":
		 		HttpSession session = request.getSession();
		        String seeker_username = (String) session.getAttribute("username");
		 		 String consult_username= request.getParameter("consultant");
		 		 boolean booked = addAppointmentDao.addAppointment(seeker_username, consult_username, appointmentDate, appointmentTime);
		         if (booked) {
		         	request.setAttribute("Message","Appointment added");
		 			request.getRequestDispatcher("addAppointment.jsp").forward(request, response);
		         } else {
		         	request.setAttribute("Message","Appointment not added");
		 			request.getRequestDispatcher("addAppointment.jsp").forward(request, response);
		         }
		         break;
		 	default:
		 		request.setAttribute("errorMessage","Appointment not added");
	 			request.getRequestDispatcher("error.jsp").forward(request, response);
	 			break;
		 	}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	
}
