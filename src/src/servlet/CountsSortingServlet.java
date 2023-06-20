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
 * Servlet implementation class CountsSortingServlet
 */
@WebServlet("/CountsSortingServlet")
public class CountsSortingServlet extends HttpServlet {
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
				// アプリ利用者選別画面にフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/countssorting.jsp");
				dispatcher.forward(request, response);
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
/*		if (session.getAttribute("id") == null) {
			response.sendRedirect("/sante/LoginServlet");
			return;
		}
*/		
		// リクエストパラメータを取得する
/*		
		request.setCharacterEncoding("UTF-8");
			int user_menber = request.getParameter("USER_MENBER");
		// 検索処理を行う
		counts user_menber = new counts(menbers);
		
		// 検索結果をセッションスコープに格納する
		session.setAttribute("user_menber", user_menber);

*/
		// 次へまたはキャンセルを行う
		//if (request.getParameter("submit").equals("次へ")) {

			//次のページに移動
			response.sendRedirect("/sante/CountsUsersRegistServlet");
			//RequestDispatcher dispatcher = request.getRequestDispatcher("/sante/CountsUsersRegistServlet");
		//}else {
			//キャンセル元のページにもどる。
			//response.sendRedirect("/sante/CountsServlet");
			
		//}
		
/*		// アプリ利用者登録画面にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/countsusersregist.jsp");
		dispatcher.forward(request, response);
	*/
	}

}
