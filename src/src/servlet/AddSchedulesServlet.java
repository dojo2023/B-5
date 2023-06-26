package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.EditingSchedules;

/**
 * Servlet implementation class AddSchedulesServlet
 */
@WebServlet("/AddSchedulesServlet")
public class AddSchedulesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする。
		//		HttpSession session = request.getSession();
		//		if (session.getAttribute("id") == null) {
		//			response.sendRedirect("/sante/LoginServlet");
		//			return;
		//		}
		// addschedulesページにフォワードする。
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/addschedules.jsp");
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
		//		if (session.getAttribute("id") == null) {
		//			response.sendRedirect("/sante/LoginServlet");
		//			return;
		//		}
		// jspのtextboxの値を取得
		if (request.getParameter("submit").equals("追加")) {
			String editing_schedules_name = request.getParameter("add_schedules_name");
			EditingSchedules dummyES = (EditingSchedules)session.getAttribute("add_schedules");
			String editing_schedules_dt = dummyES.getEditing_schedules_dt();
			// int editing_schedules_users_id = (int) session.getAttribute("id");
			// ダミー
			int editing_schedules_users_id = dummyES.getEditing_schedules_users_id();

			// 追加情報を格納
			EditingSchedules add_schedules = new EditingSchedules(editing_schedules_name, editing_schedules_dt,
					editing_schedules_users_id);
			// セッションスコープに追加情報を保存
			session.setAttribute("add_schedules", add_schedules);
			System.out.println("格納:" + add_schedules.getEditing_schedules_name() + "\n");
			System.out.println("格納:" + add_schedules.getEditing_schedules_dt() + "\n");
			System.out.println("格納:" + add_schedules.getEditing_schedules_users_id() + "\n");
			// 画面を遷移
			response.sendRedirect("/sante/AddSchedulesConfirmServlet");
		} else if (request.getParameter("submit").equals("キャンセル")) {
			// セッションスコープの破棄
			session.removeAttribute("add_schedules");
			response.sendRedirect("/sante/CalendarServlet");

		}
	}

}
