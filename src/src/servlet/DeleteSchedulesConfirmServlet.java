package servlet;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SchedulesDAO;
import model.LoginId;

/**
 * Servlet implementation class DeleteSchedulesComfirmServlet
 */
@WebServlet("/DeleteSchedulesConfirmServlet")
public class DeleteSchedulesConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする。
		HttpSession session = request.getSession();
		if (session.getAttribute("users_id") == null) {
			System.out.println("ログイン失敗");
			response.sendRedirect("/sante/LoginServlet");
			return;
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/deleteschedulesconfirm.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// もしもログインしていなかったらログインサーブレットにリダイレクトする。
		HttpSession session = request.getSession();
		if (session.getAttribute("users_id") == null) {
			System.out.println("ログイン失敗");
			response.sendRedirect("/sante/LoginServlet");
			return;
		}
		if ("削除".equals(request.getParameter("submit"))) {
			// IDとってきたはずなんで(Timestamp型なのでもしかしたら年月日合ってても時間違うとエラー吐くかも。)
			// update文のところ作ってもらってもいいですか？構造分からなかったです。
			LoginId loginId = (LoginId) session.getAttribute("users_id");
			int users_id = loginId.getUsers_id();

			String delete_schedules_name = (String) session.getAttribute("schedules_name");
			String delete_schedules_date = (String) session.getAttribute("schedules_date");
			System.out.println("schedules_id"+delete_schedules_name);
			System.out.println("schedules_id"+delete_schedules_date);

			String completeDateTime = delete_schedules_date + " 00:00:00.1";
			Timestamp delete_ts = Timestamp.valueOf(completeDateTime);
			System.out.println("schedules_id"+delete_ts);


			SchedulesDAO sDAO = new SchedulesDAO();
			int schedules_id = sDAO.getSchedulesId(delete_ts);
			System.out.println("schedules_id" + schedules_id);

			boolean deleteSuccess = sDAO.deleteSchedules(schedules_id);

			if(deleteSuccess) {

			// 画面を遷移
			session.removeAttribute("schedules_date");
			session.removeAttribute("schedules_name");
			response.sendRedirect("/sante/CalendarServlet");
			return;
			}
		} else if ("キャンセル".equals(request.getParameter("submit"))) {

			// 画面を遷移
			response.sendRedirect("/sante/ChangeSchedulesServlet");
			return;
		}

	}

}
