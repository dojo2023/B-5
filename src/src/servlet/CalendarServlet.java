package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SchedulesDAO;
import model.EditingSchedules;
import model.LoginId;
import model.Schedules;

/**
 * Servlet implementation class CalendarServlet
 */
@WebServlet("/CalendarServlet")
public class CalendarServlet extends HttpServlet {
	private Object object;
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
		// SchedulesDAOでスケジュールを取得
		SchedulesDAO sDAO = new SchedulesDAO();
		List<Schedules> schedulesList = new ArrayList<>();
		LoginId loginId = (LoginId) session.getAttribute("users_id");
		int users_id = loginId.getUsers_id();
		System.out.println("UserID:" + users_id);
		schedulesList = sDAO.getAllSchedules(users_id);
		request.setAttribute("schedulesList", schedulesList);

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

		if ("編集".equals(request.getParameter("submit"))) {
			String selected_date = request.getParameter("select_day");

			System.out.println("選択した日付:" + selected_date);

			// 現在の日付を取得し変換
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			try {
				Date toDate = sdf.parse(selected_date);
				System.out.println("ここまでは動く");
				if (toDate.before(date)) {
					System.out.println("過去");
					// SchedulesDAOでスケジュールを取得
					SchedulesDAO sDAO = new SchedulesDAO();
					List<Schedules> schedulesList = new ArrayList<>();
					LoginId loginId = (LoginId) session.getAttribute("users_id");
					int users_id = loginId.getUsers_id();
					System.out.println("テスト:" + users_id);
					schedulesList = sDAO.getAllSchedules(users_id);
					for (int i = 0; i < schedulesList.size(); i++) {
						System.out.println("for文" + i + "回目");
						System.out.println("予定日付:" + schedulesList.get(i).getSchedules_date());
						if ((schedulesList.get(i)).getSchedules_date().equals(selected_date)) {
							System.out.println("予定内容:" + schedulesList.get(i).getSchedules_name());
							System.out.println("予定有");
							session.setAttribute("schedules_date", selected_date);
							session.setAttribute("schedules_name",schedulesList.get(i).getSchedules_name());
							// 画面を遷移
							response.sendRedirect("/sante/PastSchedulesConfirmServlet");
							return;
						}
					}
					System.out.println("予定無");
					// ダミーの値を生成
					String editing_schedules_name = "";
					//Date sDate = date;
					String editing_schedules_dt = selected_date;
					System.out.println("日付確認" + editing_schedules_dt);
					int editing_schedules_users_id = loginId.getUsers_id();
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
				} else {
					System.out.println("未来");
					// SchedulesDAOでスケジュールを取得
					SchedulesDAO sDAO = new SchedulesDAO();
					List<Schedules> schedulesList = new ArrayList<>();
					LoginId loginId = (LoginId) session.getAttribute("users_id");
					int users_id = loginId.getUsers_id();
					System.out.println("テスト:" + users_id);
					schedulesList = sDAO.getAllSchedules(users_id);
					for (int i = 0; i < schedulesList.size(); i++) {
						System.out.println("for文" + i + "回目");
						System.out.println("予定日付:" + schedulesList.get(i).getSchedules_date());
						if ((schedulesList.get(i)).getSchedules_date().equals(selected_date)) {
							System.out.println("予定内容:" + schedulesList.get(i).getSchedules_name());
							System.out.println("予定有");
							session.setAttribute("schedules_date", selected_date);
							session.setAttribute("schedules_name",schedulesList.get(i).getSchedules_name());
							// 画面を遷移
							response.sendRedirect("/sante/ChangeSchedulesServlet");
							return;
						}
					}
					System.out.println("予定無");
					// ダミーの値を生成
					String editing_schedules_name = "";
					String editing_schedules_dt = selected_date;
					System.out.println("日付確認" + editing_schedules_dt);
					int editing_schedules_users_id = loginId.getUsers_id();
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
				}
			} catch (ParseException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
	}
}
