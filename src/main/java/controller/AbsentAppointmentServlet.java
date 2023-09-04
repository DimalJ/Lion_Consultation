package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AppointmentsEditDao;

/**
 * Servlet implementation class AbsentAppointmentServlet
 */
@WebServlet("/AbsentAppointmentServlet")
public class AbsentAppointmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AppointmentsEditDao appointmentEditDao;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AbsentAppointmentServlet() {
        this.appointmentEditDao = new AppointmentsEditDao();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int apponitmentId = Integer.parseInt(request.getParameter("id"));
		
		boolean affected=appointmentEditDao.removeAppointment(apponitmentId);
		if(affected) {
			 request.setAttribute("Message","Appointment Removed");
			 request.getRequestDispatcher("adminAppointmentList.jsp").forward(request, response);
		}
		else {
			 request.setAttribute("Message","Appointment not Removed");
			 request.getRequestDispatcher("adminAppointmentList.jsp").forward(request, response);
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
