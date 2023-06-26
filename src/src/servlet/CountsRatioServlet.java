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
 * Servlet implementation class CountsRatioServlet
 */
@WebServlet("/CountsRatioServlet")
public class CountsRatioServlet extends HttpServlet {
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
		// 割合画面にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/countsratio.jsp");
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
		// 登録または戻るを行う
		request.setCharacterEncoding("UTF-8");
		if (request.getParameter("submit").equals("登録")) {
			//集計登録確認画面のサーブレットにリダイレクト
			response.sendRedirect("/sante/CountsRegistConfirmServlet");
		} else {
			//杯数選択画面のサーブレットにリダイレクト
			response.sendRedirect("/sante/CountsCupsServlet");
		}

	}

}
