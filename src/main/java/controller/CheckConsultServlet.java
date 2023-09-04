package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AddAppointmentDao;

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
		 	HttpSession session = request.getSession();
		    String seeker_username = (String) session.getAttribute("username");
		    String consult_username= request.getParameter("consultant");
		    String date = request.getParameter("appointmentDate");
		    String time = request.getParameter("appointmentTime");
		    
		  boolean booked = addAppointmentDao.addAppointment(seeker_username, consult_username, date, time);
		         if (booked) {
		         	request.setAttribute("Message","Appointment added");
		 			request.getRequestDispatcher("jobSeeker.jsp").forward(request, response);
		         } else {
		         	request.setAttribute("Message","Appointment not added");
		 			request.getRequestDispatcher("jobSeeker.jsp").forward(request, response);
		         }
		         
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	
}
