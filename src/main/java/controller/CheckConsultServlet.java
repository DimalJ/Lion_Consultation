package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		 String appointmentDate = request.getParameter("appointmentDate");
	        String appointmentTime = request.getParameter("appointmentTime");

	        List<User> availableConsultants = addAppointmentDao.getAvailableConsultants(appointmentDate, appointmentTime);
	        System.out.println(availableConsultants);
	        request.setAttribute("availableConsultants", availableConsultants);
  
	        RequestDispatcher dispatcher = request.getRequestDispatcher("addAppointment.jsp");
	        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
