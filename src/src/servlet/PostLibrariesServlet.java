package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.PostLibraries;

/**
 * Servlet implementation class PostLibrariesServlet
 */
@WebServlet("/PostLibrariesServlet")
public class PostLibrariesServlet extends HttpServlet {
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
		// PostLibrariesページにフォワードする。
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/postlibraries.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// もしもログインしていなかったらログインサーブレットにリダイレクトする。
		HttpSession session = request.getSession();
		if (session.getAttribute("users_id") == null) {
			System.out.println("ログイン失敗");
			response.sendRedirect("/sante/LoginServlet");
			return;
		}
		// jspのtextboxの値を取得
		if (request.getParameter("submit").equals("投稿")) {
			String post_description = request.getParameter("description");
			String post_genre = request.getParameter("genre");
			String post_kind = request.getParameter("kind");
			String post_alcon = request.getParameter("alcon");
			String post_from = request.getParameter("from");
			String post_remarks = request.getParameter("remarks");
			System.out.println("取得:" + post_description + "\n");
			System.out.println("取得:" + post_genre + "\n");
			System.out.println("取得:" + post_kind + "\n");
			System.out.println("取得:" + post_alcon + "\n");
			System.out.println("取得:" + post_from + "\n");
			System.out.println("取得:" + post_remarks + "\n");
			if (post_description != "" && post_genre != "" && post_kind != "") {

				PostLibraries post_lib = new PostLibraries(post_description, post_genre, post_kind,
						post_alcon, post_from, post_remarks);
				// 投稿情報を格納
				post_lib.setPost_description(post_description);
				post_lib.setPost_genre(post_genre);
				post_lib.setPost_kind(post_kind);
				post_lib.setPost_alcon(post_alcon);
				post_lib.setPost_from(post_from);
				post_lib.setPost_remarks(post_remarks);

				// セッションスコープに投稿情報を保存
				session.setAttribute("post_lib", post_lib);
				System.out.println("格納:" + post_lib.getPost_description() + "\n");
				System.out.println("格納:" + post_lib.getPost_genre() + "\n");
				System.out.println("格納:" + post_lib.getPost_kind() + "\n");
				System.out.println("格納:" + post_lib.getPost_alcon() + "\n");
				System.out.println("格納:" + post_lib.getPost_from() + "\n");
				System.out.println("格納:" + post_lib.getPost_remarks() + "\n");
				// 画面を遷移
				response.sendRedirect("/sante/PostLibrariesConfirmServlet");
			} else {
				request.setAttribute("message", "銘柄、酒類、種類の入力が必要です。");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/postlibraries.jsp");
				dispatcher.forward(request, response);
			}
		} else if (request.getParameter("submit").equals("キャンセル")) {
			// セッションスコープの破棄
			session.removeAttribute("post_lib");
			response.sendRedirect("/sante/LibrariesServlet");
		}
	}

}
