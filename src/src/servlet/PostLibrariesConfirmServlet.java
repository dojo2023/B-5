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
		//		HttpSession session = request.getSession();
		//		if (session.getAttribute("id") == null) {
		//			response.sendRedirect("/sante/LoginServlet");
		//			return;
		//		}
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
				//		HttpSession session = request.getSession();
				//		if (session.getAttribute("id") == null) {
				//			response.sendRedirect("/sante/LoginServlet");
				//			return;
				//		}
		if(request.getParameter("submit").equals("はい")) {
			// DBにinsertする

			// セッションスコープの破棄
			HttpSession session = request.getSession();
	        session.removeAttribute("post_lib");
	        response.sendRedirect("/sante/LibrariesServlet");
		}else if(request.getParameter("submit").equals("いいえ")) {
			response.sendRedirect("/sante/PostLibrariesServlet");
		}
	}

}
