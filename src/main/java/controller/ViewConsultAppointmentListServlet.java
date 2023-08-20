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
 * Servlet implementation class ViewConsultAppointmentList
 */
@WebServlet("/ViewConsultAppointmentListServlet")
public class ViewConsultAppointmentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AppointmentListDao appointmentListDao;
    
    public ViewConsultAppointmentListServlet() {
       this.appointmentListDao= new AppointmentListDao();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 	String consult_username = request.getParameter("username");
	        System.out.println(consult_username);
			ArrayList<Appointment> appointmentList = appointmentListDao.getConsultAppointmentList(consult_username);
			
	        request.setAttribute("appointmentList", appointmentList);
	        request.getRequestDispatcher("consultAppointmentList.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
