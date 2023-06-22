package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PhysicalsDAO;
import dao.UsersDAO;
import model.Physicals;

/**
 * Servlet implementation class MypagePhysicalsServlet
 */
@WebServlet("/MypagePhysicalsServlet")
public class MypagePhysicalsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		/*if (session.getAttribute("id") == null) {
			response.sendRedirect("/sante/LoginServlet");
			return;
	}*/
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mypagephysicals.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		//パラメーター取得
		request.setCharacterEncoding("UTF-8");
		UsersDAO usersDAO = new UsersDAO();
		int users_id = usersDAO.getMaxUserID();
		int physicals_id = Integer.parseInt(request.getParameter("physicals_id"));
		int physicals_resistance = Integer.parseInt(request.getParameter("physicals_resistance"));
		int physicals_condition = Integer.parseInt(request.getParameter("physicals_condition"));


		PhysicalsDAO physiDao = new PhysicalsDAO();
		boolean updateSuccess = physiDao.updatePhysicals(new Physicals(users_id, physicals_id, physicals_resistance, physicals_condition, null, null));
		if (updateSuccess) {
			response.sendRedirect("/sante/MypageServlet");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mypage.jsp");
		dispatcher.forward(request, response);
	}

}
