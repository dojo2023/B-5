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
 * Servlet implementation class CountsUsersRegistConfirmServlet
 */
@WebServlet("/CountsRegistConfirmServlet")
public class CountsUsersRegistConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
/*		if (session.getAttribute("id") == null) {
			response.sendRedirect("/sante/LoginServlet");
			return;
		}
*/
		// 杯数選択画面にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/countscups.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
//		if (session.getAttribute("id") == null) {
//			response.sendRedirect("/sante/LoginServlet");
//			return;
//		}

		// はいまたはいいえを行う
		if (request.getParameter("SUBMIT").equals("はい")) {
			//次のサーブレットにリダイレクト
			response.sendRedirect("/sante/Servlet");
		//セッションスコープ"dinrks"の値を読み込む(Drinks型)
			
		//DBのテーブルに格納するDAOを呼び出す(引数として上の値を渡す)
		
			
		}else {
			//元のページにもどる。
		}
		
		// カレンダー画面にフォワードする
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/calendar.jsp");
					dispatcher.forward(request, response);
	}

}
