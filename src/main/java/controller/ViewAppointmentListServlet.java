package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.AppointmentListDao;
import model.Appointment;

/**
 * Servlet implementation class ViewAppointmentList
 */
@WebServlet("/ViewAppointmentListServlet")
public class ViewAppointmentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AppointmentListDao appointmentListDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAppointmentListServlet() {
        this.appointmentListDao = new AppointmentListDao();
     
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        String seeker_username = request.getParameter("username");
       
		ArrayList<Appointment> appointmentList = appointmentListDao.getAppointmentList(seeker_username);
        request.setAttribute("appointmentList", appointmentList);
        
        request.getRequestDispatcher("seekerAppointmentList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
