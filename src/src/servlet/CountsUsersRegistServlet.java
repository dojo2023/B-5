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
				if (session.getAttribute("id") == null) {
					response.sendRedirect("/sante/LoginServlet");
					return;
				}
				
				// アプリ利用者数選別画面にフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/countssorting.jsp");
				dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*		// もしもログインしていなかったらログインサーブレットにリダイレクトする
			HttpSession session = request.getSession();
			if (session.getAttribute("id") == null) {
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
		
		// 更新または削除を行う
/*				CountsDAO cDao = new CountsDAO();
				if (request.getParameter("next").equals("次へ")) {
					if (cDao.update(new Counts(counts))) {	// 更新成功
						request.setAttribute("result",
						new Result("更新成功！", "レコードを更新しました。", "/sante/Servlet"));
					}
					else {												// 更新失敗
						request.setAttribute("result",
						new Result("更新失敗！", "レコードを更新できませんでした。", "/sante/Servlet"));
					}
				}
				else {
					if (cDao.delete(number)) {	// 削除成功
						request.setAttribute("result",
						new Result("削除成功！", "レコードを削除しました。", "/sante/Servlet"));
					}
					else {						// 削除失敗
						request.setAttribute("result",
						new Result("削除失敗！", "レコードを削除できませんでした。", "/sante/Servlet"));
					}
				}
*/		
		// 杯数選択画面にフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/countscups.jsp");
			dispatcher.forward(request, response);
	}

}
