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
import model.Appointment;

/**
 * Servlet implementation class CheckConsultantTime
 */
@WebServlet("/CheckConsultantTime")
public class CheckConsultantTime extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AddAppointmentSpecialtyDao addAppointmentSpecialtyDao;     
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckConsultantTime() {
        super();
       addAppointmentSpecialtyDao = new AddAppointmentSpecialtyDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String consult_username= request.getParameter("consultant");
 		List<Appointment> availableTime = addAppointmentSpecialtyDao.getAvailablTime(consult_username);
 		System.out.println(availableTime);
 		request.setAttribute("availableTime", availableTime);
 		request.setAttribute("username", consult_username);
 		System.out.println(consult_username);
 		RequestDispatcher dispatcher = request.getRequestDispatcher("addAppointmentSpecialty.jsp");
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
