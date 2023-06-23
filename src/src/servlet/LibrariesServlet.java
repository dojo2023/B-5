package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LibrariesDAO;
import model.Libraries;

/**
 * Servlet implementation class LibrariesServlet
 */
@WebServlet("/LibrariesServlet")
public class LibrariesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする。
		//				HttpSession session = request.getSession();
		//				if (session.getAttribute("id") == null) {
		//					response.sendRedirect("/sante/LoginServlet");
		//					return;
		//				}

		request.setCharacterEncoding("UTF-8");
		//図鑑全体テーブルを表示する



		String keyword = request.getParameter("search_box");
		if (request.getParameter("submit").equals("検索")) {
			//ここだけ修正必要
			//キーワード検索で結果を表示する
			if (keyword != null && !keyword.isEmpty()) {
	            // キーワード検索で結果を取得
	            LibrariesDAO librariesDAO = new LibrariesDAO();
	            List<Libraries> searchList = librariesDAO.searchLibraries(keyword);

	            // 検索結果をリクエスト属性に保存
	            request.setAttribute("searchList", searchList);

//				//検索結果を表示
//				response.sendRedirect("/sante/LibrariesServlet");
	        } else {
	        	//検索結果を表示
				response.sendRedirect("/sante/LibrariesServlet");
	        }

		} else if (request.getParameter("submit").equals("絞り込み")) {
			//絞り込み検索画面へとリダイレクトする。
			response.sendRedirect("/sante/NarrowLibrariesServlet");
		} else if (request.getParameter("submit").equals("投稿")) {
			//投稿画面へとリダイレクトする。
			response.sendRedirect("/sante/PostLibrariesServlet");
		} else if (request.getParameter("submit").equals("お気に入り")) {
			//お気に入り画面へとリダイレクトする。
			response.sendRedirect("/sante/BookmarksServlet");
		}

	}

}
