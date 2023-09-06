package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReportDao;

/**
 * Servlet implementation class ReportServlet
 */
@WebServlet("/ReportServlet")
public class ReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ReportDao reportDao;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportServlet() {
        super();
        this.reportDao = new ReportDao();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int newUser= reportDao.getNewUser();
		int totalUser = reportDao.getTotalUser();
		int totalConsult = reportDao.getTotalConsultUser();
		int monthlyAppo = reportDao.getMonthlyappointment();
		int totalAppo = reportDao.getTotalappointment();
		int pendingAppo = reportDao.getPendingappointment();
		
		request.setAttribute("newUser", newUser);
 		request.setAttribute("totalUser", totalUser);
 		request.setAttribute("totalConsult", totalConsult);
 		request.setAttribute("totalAppo", totalAppo);
 		request.setAttribute("pendingAppo", pendingAppo);
 		request.setAttribute("monthlyAppo", monthlyAppo);
 		
 		RequestDispatcher dispatcher = request.getRequestDispatcher("report.jsp");
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
