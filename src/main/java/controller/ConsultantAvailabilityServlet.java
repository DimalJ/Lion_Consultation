package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ConsultantDao;

/**
 * Servlet implementation class ConsultantAvailability
 */
@WebServlet("/ConsultantAvailabilityServlet")
public class ConsultantAvailabilityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ConsultantDao consultantDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultantAvailabilityServlet() {
       super();  
    }
    public void init(){
    	consultantDao =new ConsultantDao();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        
        String availableDate = request.getParameter("availableDate");
        String startTime = request.getParameter("start_time");
        String finishTime = request.getParameter("finish_time");

        boolean added = false;
		try {
			added = consultantDao.addAvailability(username, availableDate, startTime, finishTime);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        if (added) {
            response.sendRedirect("consultants.jsp");
            System.out.println(username+" "+startTime+" " + finishTime);
        } else {
            response.sendRedirect("error.jsp");
            System.out.println(username+" "+startTime);
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
