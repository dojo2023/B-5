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
		if (request.getParameter("submit").equals("絞り込み")) {
			// 処理結果をセッションスコープに入れる必要あり。要記載

			response.sendRedirect("/sante/LibrariesServlet");
		} else if (request.getParameter("submit").equals("キャンセル")) {
			response.sendRedirect("/sante/LibrariesServlet");
		}

	}

}
