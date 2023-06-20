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
 * Servlet implementation class CountsServlet
 */
@WebServlet("/CountsServlet")
public class CountsServlet extends HttpServlet {
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

		// 集計入力画面にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/counts.jsp");
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
			request.setCharacterEncoding("UTF-8");
		//	int all_menber = request.getParameter("ALL_MENBER");
				
		// 検索処理を行う
		//	counts all_menber = new counts(menbers);
			//ここはモデルをインスタンス化して引数としてカウントを指定する

		// 検索結果をセッションスコープに格納する
			//session.setAttribute("all_menber", all_menber);
			
		// 次へを行う
			request.setCharacterEncoding("UTF-8");
			if (request.getParameter("submit").equals("次へ")) {
				//CountSortingServletサーブレットに処理を渡す(リダイレクト)
				response.sendRedirect("/sante/CountsSortingServlet");
				
			}
	}

}