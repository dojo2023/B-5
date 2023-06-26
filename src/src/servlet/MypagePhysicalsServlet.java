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
import model.LoginId;
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// もしもログインしていなかったらログインサーブレットにリダイレクトする。
		HttpSession session = request.getSession();
		if (session.getAttribute("users_id") == null) {
			System.out.println("ログイン失敗");
			response.sendRedirect("/sante/LoginServlet");
			return;
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mypagephysicals.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする。
		HttpSession session = request.getSession();
		if (session.getAttribute("users_id") == null) {
			System.out.println("ログイン失敗");
			response.sendRedirect("/sante/LoginServlet");
			return;
		}
		//パラメーター取得
		request.setCharacterEncoding("UTF-8");

		// セッションスコープからLoginIdオブジェクトを取得し、users_idを取得する
		LoginId loginId = (LoginId) session.getAttribute("users_id");
		int users_id = loginId.getUsers_id();

		int physicals_resistance = Integer.parseInt(request.getParameter("physicals_resistance"));
		int physicals_condition = Integer.parseInt(request.getParameter("physicals_condition"));

		System.out.println(physicals_resistance);
		System.out.println(physicals_condition);
		System.out.println(users_id);

		PhysicalsDAO physiDao = new PhysicalsDAO();
		boolean updateSuccess = physiDao
				.updatePhysicals(new Physicals(0, users_id, physicals_resistance, physicals_condition, null, null));
		if (updateSuccess) {
			response.sendRedirect("/sante/MypageServlet");
		} else {
			response.sendRedirect("/sante/Servlet");
		}
		//		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mypage.jsp");
		//		dispatcher.forward(request, response);
	}

}
