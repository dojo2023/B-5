package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import model.Drinks;

/**
 * Servlet implementation class CountsCupsServlet
 */
@WebServlet("/CountsCupsServlet")
public class CountsCupsServlet extends HttpServlet {
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

		// 杯数選択画面にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/countscups.jsp");
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

		ArrayList<String> counts_list = new ArrayList<String>();
		if (request.getParameter("submit").equals("登録")) {

			for (int i = 1; i < 11; i++) {
				if (request.getParameter("counts_cups" + i) != null) {
					System.out.println(request.getParameter("counts_cups" + i));
					System.out.println("counts_cups" + i);

					String counts_cups = request.getParameter("counts_cups" + i);

					counts_list.add(counts_cups);
				}
			}

			session.setAttribute("counts_list", counts_list);

			System.out.println(counts_list);

			//集計登録確認画面のサーブレットにリダイレクト
			response.sendRedirect("/sante/CountsRegistConfirmServlet");

		} else if (request.getParameter("submit").equals("割合表示")) {
			//割合画面のサーブレットにリダイレクト
			response.sendRedirect("/sante/CountsRatioServlet");
		}

	}

}
