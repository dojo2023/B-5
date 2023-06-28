package servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SchedulesDAO;
import model.EditingSchedules;
import model.Schedules;

/**
 * Servlet implementation class AddSchedulesConfirmServlet
 */
@WebServlet("/AddSchedulesConfirmServlet")
public class AddSchedulesConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする。
		HttpSession session = request.getSession();
		if (session.getAttribute("users_id") == null) {
			System.out.println("ログイン失敗");
			response.sendRedirect("/sante/LoginServlet");
			return;
		}
		// addschedulesページにフォワードする。
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/addschedulesconfirm.jsp");
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
		// jspのtextboxの値を取得
		if (request.getParameter("submit").equals("登録")) {
			EditingSchedules editingSchedules = (EditingSchedules) session.getAttribute("add_schedules");
			String editing_schedules_name = editingSchedules.getEditing_schedules_name();
			//String→Date→Timestamp
			String editing_schedules_dt = editingSchedules.getEditing_schedules_dt();
			System.out.println("予定テスト" + editing_schedules_name);
			System.out.println("日付テスト" + editing_schedules_dt);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date_esd;
			try {
				date_esd = sdf.parse(editing_schedules_dt);
				Timestamp ts_esd = new Timestamp(date_esd.getTime());
				int editing_schedules_users_id = editingSchedules.getEditing_schedules_users_id();

				//DBに送信
				SchedulesDAO schedulesDAO = new SchedulesDAO();
				boolean insertSuccess = schedulesDAO.insertSchedules(
						new Schedules(0, editing_schedules_name, ts_esd, editing_schedules_users_id, null, null));
				if (insertSuccess) {
					// セッションスコープの破棄
					session.removeAttribute("add_schedules_dt");
					// 画面を遷移
					response.sendRedirect("/sante/CalendarServlet");
				}
			} catch (ParseException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		} else if (request.getParameter("submit").equals("戻る")) {
			response.sendRedirect("/sante/AddSchedulesServlet");

		}
	}

}
