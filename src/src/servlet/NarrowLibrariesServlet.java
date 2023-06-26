package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LibrariesDAO;
import model.Libraries;

/**
 * Servlet implementation class NarrowLibrariesServlet
 */
@WebServlet("/NarrowLibrariesServlet")
public class NarrowLibrariesServlet extends HttpServlet {
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

		//検索処理を行う

		//librariesページにフォワードする。
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/narrowlibraries.jsp");
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
		    request.setCharacterEncoding("UTF-8");

		    String keyword = request.getParameter("search_box");
		    String genre = request.getParameter("genre");
		    String kind = request.getParameter("kind");
		    String from = request.getParameter("from");
		    if ("-選択-".equals(genre)) {
		    	genre = "";
		    }
		    if ("-選択-".equals(kind)) {
		        kind = "";
		    }

		    if ("-選択-".equals(from)) {
		        from = "";


		    System.out.print(genre);
		    System.out.print(kind);
		    System.out.print(from);
		    if ("検索".equals(request.getParameter("submit"))) {
		        // キーワード検索
		        if (keyword != null && !keyword.isEmpty()) {
		            LibrariesDAO librariesDAO = new LibrariesDAO();
		            List<Libraries> searchList = librariesDAO.searchLibraries(keyword);
		            request.setAttribute("searchList", searchList);
		        }
		    } else if ("絞り込み".equals(request.getParameter("submit"))) {
		        // 絞り込み検索
		        LibrariesDAO librariesDAO = new LibrariesDAO();
		        List<Libraries> narrowList = librariesDAO.narrowLibraries(genre, kind, from);
		        request.setAttribute("narrowList", narrowList);
		    } else if ("投稿".equals(request.getParameter("submit"))) {
		        // 投稿画面へとリダイレクトする。
		        response.sendRedirect("/sante/PostLibrariesServlet");
		    } else if ("お気に入り".equals(request.getParameter("submit"))) {
		        // お気に入り画面へとリダイレクトする。
		        response.sendRedirect("/sante/BookmarksServlet");
		    }

		    // librariesページにフォワードする。
		    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/libraries.jsp");
		    dispatcher.forward(request, response);
		}
	}
}
