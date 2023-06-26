package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LibrariesDAO;
import model.PostLibraries;

/**
 * Servlet implementation class PostLibrariesConfirmServlet
 */
@WebServlet("/PostLibrariesConfirmServlet")
public class PostLibrariesConfirmServlet extends HttpServlet {
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
		// postlibrariesconfirmページにフォワードする。
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/postlibrariesconfirm.jsp");
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
		if (request.getParameter("submit").equals("はい")) {
			// DBにinsertする
			PostLibraries post_lib = (PostLibraries) session.getAttribute("post_lib");

			//			int libraries_id = post_lib.getLibraries_id;
			String post_description = post_lib.getPost_description();
			String post_genre = post_lib.getPost_genre();
			String post_kind = post_lib.getPost_kind();
			String post_alcon = post_lib.getPost_alcon();
			String post_from = post_lib.getPost_from();
			String post_remarks = post_lib.getPost_remarks();

			System.out.println(post_description);
			System.out.println(post_genre);
			System.out.println(post_kind);
			System.out.println(post_alcon);
			System.out.println(post_from);
			System.out.println(post_remarks);

			LibrariesDAO librariesDAO = new LibrariesDAO();
			boolean insertSuccess = librariesDAO.insertLibraries(
					new PostLibraries(post_description, post_genre, post_kind, post_alcon, post_from, post_remarks));

			if (insertSuccess) {
				// セッションスコープの破棄
				session.removeAttribute("post_lib");
				response.sendRedirect("/sante/LibrariesServlet");
			} else if (request.getParameter("submit").equals("いいえ")) {
				response.sendRedirect("/sante/PostLibrariesServlet");
			}
		}

	}
}