package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PhysicalsDAO;
import model.Physicals;

/**
 * Servlet implementation class RegistPhysicalsServlet
 */
@WebServlet("/RegistPhysicalsServlet")
public class RegistPhysicalsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registphysicals.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int physicals_id = Integer.parseInt(request.getParameter("physicals_id"));
		int users_id=Integer.parseInt(request.getParameter("users_id"));
		int physicals_resistance = Integer.parseInt(request.getParameter("physicals_resistance"));
		int physicals_condition = Integer.parseInt(request.getParameter("physicals_condition"));

		PhysicalsDAO PhysiDao = new PhysicalsDAO();
		if(PhysiDao.insert(new Physicals(physicals_id, users_id, physicals_resistance, physicals_condition, null, null));

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/calendar.jsp");
		dispatcher.forward(request, response);
	}

}
