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
 * Servlet implementation class PastSchedulesComfirmServlet
 */
@WebServlet("/FutureSchedulesConfirmServlet")
public class FutureSchedulesConfirmServlet extends HttpServlet {
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
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/futureschedulesconfirm.jsp");
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
//		if (session.getAttribute("users_id") == null) {
//			System.out.println("ログイン失敗");
//			response.sendRedirect("/sante/LoginServlet");
//			return;
//		}
		if (request.getParameter("submit").equals("更新")) {
			EditingSchedules editingSchedules = (EditingSchedules) session.getAttribute("update_schedules");
			String editing_schedules_name = editingSchedules.getEditing_schedules_name();
			//String→Date→Timestamp
			String editing_schedules_dt = editingSchedules.getEditing_schedules_dt();
			System.out.println("予定テスト" + editing_schedules_name);
			System.out.println("日付テスト" + editing_schedules_dt);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			Date date_esd;
			try {
				date_esd = sdf.parse(editing_schedules_dt);
				Timestamp ts_esd = new Timestamp(date_esd.getTime());
				int editing_schedules_users_id = editingSchedules.getEditing_schedules_users_id();

				//DBに送信
				SchedulesDAO updateDAO = new SchedulesDAO();
				boolean updateSuccess = updateDAO.updateSchedules(new
						Schedules(0, editing_schedules_name, ts_esd, editing_schedules_users_id, null, null));
				if (updateSuccess) {
					// セッションスコープの破棄
					session.removeAttribute("update_schedules_dt");
					// 画面を遷移
					response.sendRedirect("/sante/CalendarServlet");
				}
			} catch (ParseException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

		}else if(request.getParameter("submit").equals("削除")) {
		EditingSchedules editingSchedules = (EditingSchedules) session.getAttribute("update_schedules");
	    String editing_schedules_name = editingSchedules.getEditing_schedules_name();
	    String editing_schedules_dt = editingSchedules.getEditing_schedules_dt();
	    System.out.println("予定テスト" + editing_schedules_name);
	    System.out.println("日付テスト" + editing_schedules_dt);

	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	    Date date_esd;
	    try {
	        date_esd = sdf.parse(editing_schedules_dt);
	        Timestamp ts_esd = new Timestamp(date_esd.getTime());

	        // スケジュールのIDを取得
	        SchedulesDAO schedulesDAO = new SchedulesDAO();
	        int schedulesId = schedulesDAO.getSchedulesId(editing_schedules_name, ts_esd);

	        if (schedulesId != -1) {
	            // スケジュールを削除
	            boolean deleteSuccess = schedulesDAO.deleteSchedules(schedulesId);
	            if (deleteSuccess) {
	                // セッションスコープの破棄
	                session.removeAttribute("update_schedules_dt");
	                // 画面を遷移
	                response.sendRedirect("/sante/CalendarServlet");
	            } else {
	                // 削除失敗時の処理
	            }
	        }
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
	}
	}
}
