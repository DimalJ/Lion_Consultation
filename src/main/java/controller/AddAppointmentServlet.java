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
 * Servlet implementation class AddAppointmentServlet
 */
@WebServlet("/AddAppointmentServlet")
public class AddAppointmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AddAppointmentDao addAppointmentDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAppointmentServlet() {
       this.addAppointmentDao=new AddAppointmentDao();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
        String seeker_username = (String) session.getAttribute("username");
        
        String appointmentDate = request.getParameter("appointmentDate");
        System.out.println(appointmentDate);
        String appointmentTime = request.getParameter("appointmentTime");
        System.out.println(appointmentTime);
        String consult_username= request.getParameter("consultant");
        System.out.println(consult_username);
        
      
        
        boolean booked = addAppointmentDao.addAppointment(seeker_username, consult_username, appointmentDate, appointmentTime);
        if (booked) {
        	request.setAttribute("Message","Appointment added");
			request.getRequestDispatcher("jobseeker.jsp").forward(request, response);
        } else {
        	request.setAttribute("errorMessage","Appointment not added");
			request.getRequestDispatcher("error.jsp").forward(request, response);
        }
        
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
