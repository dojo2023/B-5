package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookmarksConfirmServlet
 */
@WebServlet("/BookmarksConfirmServlet")
public class BookmarksConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする。
		//		HttpSession session = request.getSession();
		//		if (session.getAttribute("id") == null) {
		//			response.sendRedirect("/sante/LoginServlet");
		//			return;
		//		}

		//検索処理を行う

		//bookmarksconfirmページにフォワードする。
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/bookmarksconfirm.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする。
				//		HttpSession session = request.getSession();
				//		if (session.getAttribute("id") == null) {
				//			response.sendRedirect("/sante/LoginServlet");
				//			return;
				//		}
				request.setCharacterEncoding("UTF-8");
				if(request.getParameter("submit").equals("はい")) {
					//ここだけ修正必要
					//検索結果を表示
					response.sendRedirect("/sante/LibrariesServlet");

				}else if(request.getParameter("submit").equals("いいえ")){
					//お気に入り選択画面へとリダイレクトする。
					response.sendRedirect("/sante/BookmarksServlet");
				}
	}

}
