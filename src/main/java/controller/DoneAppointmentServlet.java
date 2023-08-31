package controller;

import java.io.IOException;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AppointmentsEditDao;

/**
 * Servlet implementation class DoneAppointmentServlet
 */
@WebServlet("/DoneAppointmentServlet")
public class DoneAppointmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AppointmentsEditDao appointmentEditDao;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoneAppointmentServlet() {
        this.appointmentEditDao = new AppointmentsEditDao();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int apponitmentId = Integer.parseInt(request.getParameter("id"));
		String seeker_username=request.getParameter("seekerUsername");
		String consult_username=request.getParameter("consultUsername");
		String date=request.getParameter("date");
		String startTime = request.getParameter("startTime");
		
		LocalTime currentTime = LocalTime.now();
        int hours = currentTime.getHour();
        int minutes = currentTime.getMinute();

        String formattedHours = (hours < 10) ? "0" + hours : String.valueOf(hours);
        String formattedMinutes = (minutes < 10) ? "0" + minutes : String.valueOf(minutes);

        String endTime = formattedHours + ":" + formattedMinutes;
        
        
        
        
        boolean done= appointmentEditDao.addAppointment(seeker_username, consult_username, date, startTime, endTime);
        System.out.println(date);
        System.out.println(startTime);
        System.out.println(endTime);
        
        if ( done==true) {
        	 request.setAttribute("Message","Appointment finished");
        	 
			 request.getRequestDispatcher("consultants.jsp").forward(request, response);
			 appointmentEditDao.removeAppointment(apponitmentId);
        }
        else {
        	 request.setAttribute("Message","Appointment not finished");
			 request.getRequestDispatcher("DoneAppointment.jsp").forward(request, response);
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
