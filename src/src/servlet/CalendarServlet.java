package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.EditingSchedules;

/**
 * Servlet implementation class CalendarServlet
 */
@WebServlet("/CalendarServlet")
public class CalendarServlet extends HttpServlet {
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
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/calendar.jsp");
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
		// ダミーボタンの処理なので最終的に全部消すこと。
		if (request.getParameter("submit").equals("過去予定無")) {
			// ダミーの値を生成
			String editing_schedules_name = "ダミー過去予定無";
			Date dummy = new Date();
			String editing_schedules_dt = new SimpleDateFormat("yyyy/MM/dd").format(dummy);
			int editing_schedules_users_id = 1;
			// ダミーの追加情報を格納
			EditingSchedules add_schedules = new EditingSchedules(editing_schedules_name, editing_schedules_dt,
					editing_schedules_users_id);
			// セッションスコープに追加情報を保存
			session.setAttribute("add_schedules", add_schedules);
			System.out.println("格納:" + add_schedules.getEditing_schedules_name() + "\n");
			System.out.println("格納:" + add_schedules.getEditing_schedules_dt() + "\n");
			System.out.println("格納:" + add_schedules.getEditing_schedules_users_id() + "\n");
			// 画面を遷移
			response.sendRedirect("/sante/AddSchedulesServlet");
		} else if (request.getParameter("submit").equals("過去予定有")) {

			// 画面を遷移
			response.sendRedirect("/sante/PastSchedulesConfirmServlet");
		} else if (request.getParameter("submit").equals("未来予定無")) {
			// ダミーの値を生成
			String editing_schedules_name = "ダミー未来予定無";
			Date dummy = new Date();
			String editing_schedules_dt = new SimpleDateFormat("yyyy/MM/dd").format(dummy);
			int editing_schedules_users_id = 1;
			// ダミーの追加情報を格納
			EditingSchedules add_schedules = new EditingSchedules(editing_schedules_name, editing_schedules_dt,
					editing_schedules_users_id);
			// セッションスコープに追加情報を保存
			session.setAttribute("add_schedules", add_schedules);
			System.out.println("格納:" + add_schedules.getEditing_schedules_name() + "\n");
			System.out.println("格納:" + add_schedules.getEditing_schedules_dt() + "\n");
			System.out.println("格納:" + add_schedules.getEditing_schedules_users_id() + "\n");
			// 画面を遷移
			response.sendRedirect("/sante/AddSchedulesServlet");
		} else if (request.getParameter("submit").equals("未来予定有")) {

		}
	}

}
