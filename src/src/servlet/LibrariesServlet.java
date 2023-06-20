package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LibrariesServlet
 */
@WebServlet("/LibrariesServlet")
public class LibrariesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする。
//				HttpSession session = request.getSession();
//				if (session.getAttribute("id") == null) {
//					response.sendRedirect("/sante/LoginServlet");
//					return;
//				}

		//検索処理を行う

		//librariesページにフォワードする。
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/libraries.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする。
//				HttpSession session = request.getSession();
//				if (session.getAttribute("id") == null) {
//					response.sendRedirect("/sante/LoginServlet");
//					return;
//				}
//		Map<String, String[]> form = request.getParameterMap();
//		String dispatcher =
//				form.containsKey("narrow")?"/NarrowLibrariesServlet":
//				form.containsKey("post")?"/PostLibrariesServlet":
//				form.containsKey("bookmarks")?"/BookmarksServlet":
//					null;
//		if(dispatcher == null) {
//
//		}else {
//			getServletContext().getRequestDispatcher(dispatcher).forward(request, response);
//		}
		request.setCharacterEncoding("UTF-8");
		if(request.getParameter("submit").equals("検索")) {
			//ここだけ修正必要
			//検索結果を表示
			response.sendRedirect("/sante/LibrariesServlet");

		}else if(request.getParameter("submit").equals("絞り込み")){
			//絞り込み検索画面へとリダイレクトする。
			response.sendRedirect("/sante/NarrowLibrariesServlet");
		}else if(request.getParameter("submit").equals("投稿")) {
			//投稿画面へとリダイレクトする。
			response.sendRedirect("/sante/PostLibrariesServlet");
		}else if(request.getParameter("submit").equals("お気に入り") ){
			//お気に入り画面へとリダイレクトする。
			response.sendRedirect("/sante/BookmarksServlet");
		}

	}

}
