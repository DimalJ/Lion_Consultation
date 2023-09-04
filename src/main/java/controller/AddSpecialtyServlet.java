package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SpecialityAddDao;

/**
 * Servlet implementation class AddSpecialtyServlet
 */
@WebServlet("/AddSpecialtyServlet")
public class AddSpecialtyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private SpecialityAddDao specialityAddDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSpecialtyServlet() {
        super();
        this.specialityAddDao = new SpecialityAddDao();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String industry = request.getParameter("industry");
		String region = request.getParameter("region");
		
		boolean affected = specialityAddDao.addSpecialty(username, industry, region);
		if (affected) {
        	request.setAttribute("Message","Specialty added");
			request.getRequestDispatcher("admin.jsp").forward(request, response);
        } else {
        	request.setAttribute("errorMessage","specialty not added");
			request.getRequestDispatcher("admin.jsp").forward(request, response);
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
