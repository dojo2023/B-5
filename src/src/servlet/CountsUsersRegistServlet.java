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
 * Servlet implementation class CountsUsersRegistServlet
 */
@WebServlet("/CountsUsersRegistServlet")
public class CountsUsersRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
				HttpSession session = request.getSession();
/*				if (session.getAttribute("id") == null) {
					response.sendRedirect("/sante/LoginServlet");
					return;
				}
*/				
				// アプリ利用者登録画面にフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/countsusersregist.jsp");
				dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
			HttpSession session = request.getSession();
/*			if (session.getAttribute("id") == null) {
				response.sendRedirect("/sante/LoginServlet");
				return;
				}
*/
		
		// リクエストパラメータを取得する
/*				request.setCharacterEncoding("UTF-8");
		String counts = request.getParameter("COUNTS");
		
		// 検索処理を行う
	    CountsDAO cDao = new CountsDAO();
		List<Counts> cardList = cDao.select(new Counts(counts));

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("cardList", cardList);
*/
		
		// 次へまたはキャンセルを行う
			request.setCharacterEncoding("UTF-8");
			if (request.getParameter("submit").equals("次へ")) {
			//次のサーブレットにリダイレクト
			response.sendRedirect("/sante/CountsCupsServlet");
		}else {
			//キャンセル元のサーブレットにもどる。
			response.sendRedirect("/sante/CountsSortingServlet");
		}		
		
	}

}
