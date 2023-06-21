package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PhysicalsDAO;
import dao.UsersDAO;
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
		UsersDAO usersDAO = new UsersDAO();
		int users_id = usersDAO.getMaxUserID();
		int physicals_resistance = Integer.parseInt(request.getParameter("physicals_resistance"));
		int physicals_condition = Integer.parseInt(request.getParameter("physicals_condition"));
		System.out.println("取得:" + physicals_resistance + "\n");
		System.out.println("取得:" + physicals_condition + "\n");
		PhysicalsDAO physiDao = new PhysicalsDAO();
		boolean insertSuccess = physiDao.insertPhysicals(new Physicals(0, users_id, physicals_resistance, physicals_condition, null, null));
		if(insertSuccess) {
//			if (request.getParameter("submit").equals("登録")) {
				response.sendRedirect("/sante/CalendarServlet");
//			}
//			request.getRequestDispatcher("/sante/CalendarServlet").forward(request, response);
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/calendar.jsp");
//			dispatcher.forward(request, response);
		} else {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/usersresult.jsp");
		dispatcher.forward(request, response);
		}
	}

}
