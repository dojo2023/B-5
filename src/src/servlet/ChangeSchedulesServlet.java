package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ChangeSchedulesServlet
 */
@WebServlet("/ChangeSchedulesServlet")
public class ChangeSchedulesServlet extends HttpServlet {
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
		// changeschedulesページにフォワードする。
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/changeschedules.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// もしもログインしていなかったらログインサーブレットにリダイレクトする。
		HttpSession session = request.getSession();
		if (session.getAttribute("users_id") == null) {
			System.out.println("ログイン失敗");
			response.sendRedirect("/sante/LoginServlet");
			return;
		}
		if ("更新".equals(request.getParameter("submit"))) {
			String update_schedules_name = request.getParameter("change_schedules_name");
			String update_schedules_date = request.getParameter("change_schedules_date");
			session.setAttribute("schedules_name", update_schedules_name);
			session.setAttribute("schedules_date", update_schedules_date);

			// 画面を遷移
			response.sendRedirect("/sante/ChangeSchedulesConfirmServlet");
			return;
		} else if ("削除".equals(request.getParameter("submit"))) {
			String delete_schedules_name = request.getParameter("change_schedules_name");
			String delete_schedules_date = request.getParameter("change_schedules_date");
			session.setAttribute("schedules_name", delete_schedules_name);
			session.setAttribute("schedules_date", delete_schedules_date);

			// 画面を遷移
			response.sendRedirect("/sante/DeleteSchedulesConfirmServlet");
			return;
		} else if ("キャンセル".equals(request.getParameter("submit"))){
			// セッションスコープの破棄
			session.removeAttribute("schedules_date");
			session.removeAttribute("schedules_name");
			response.sendRedirect("/sante/CalendarServlet");
			return;
		}
	}

}
