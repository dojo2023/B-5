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
 * Servlet implementation class CountsRegistConfirmServlet
 */
@WebServlet("/CountsRegistConfirmServlet")
public class CountsRegistConfirmServlet extends HttpServlet {
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
		// 集計登録確認画面にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/countsregistconfirm.jsp");
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

		// はいまたはいいえを行う
		request.setCharacterEncoding("UTF-8");
		
		if (request.getParameter("submit").equals("はい")) {
			
			
			// 登録処理を行う
//			CountsDAO cDao = new CountsDAO();
			
			// リクエストパラメータを取得する
//			int counts_alcohol = Integer.parseInt(counts_cups);
//			int users_id = Integer.parseInt(user_id);
//			
//			if (cDao.insertCounts(new Counts())) {	
//				System.out.println("success");
//			}
				
				//カレンダーのサーブレットにリダイレクト
				response.sendRedirect("/sante/CalendarServlet");
			

		} else {
			//杯数選択画面のサーブレットにリダイレクト
			response.sendRedirect("/sante/CountsCupsServlet");
		}

	}

}
