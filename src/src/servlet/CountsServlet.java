package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.PostCounts;

/**
 * Servlet implementation class CountsServlet
 */
@WebServlet("/CountsServlet")
public class CountsServlet extends HttpServlet {
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
		//ヘッダーで遷移した際のセッションスコープの破棄
		session.removeAttribute("schedules_date");
		session.removeAttribute("schedules_name");
		session.removeAttribute("add_schedules");
		session.removeAttribute("post_lib");
		session.removeAttribute("post_counts");
		// 集計入力画面にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/counts.jsp");
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

		if (request.getParameter("submit").equals("次へ")) {
			try {
				int all_member = Integer.parseInt(request.getParameter("counts"));

				if (all_member != 0) {
					PostCounts counts_cou = new PostCounts();
					// 投稿情報を格納
					counts_cou.setAll_member(all_member);
					session.setAttribute("post_counts", counts_cou);

					if (all_member < 0) {
						// 集計入力画面にフォワードする
						RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/counts.jsp");
						request.setAttribute("erro", "0以上を入力してください");
						dispatcher.forward(request, response);
					} else if (all_member > 10) {
						// 集計入力画面にフォワードする
						RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/counts.jsp");
						request.setAttribute("erro", "10以下で入力してください");
						dispatcher.forward(request, response);
					}
				} else if (all_member == 0) {
					// 集計入力画面にフォワードする
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/counts.jsp");
					request.setAttribute("erro", "0以外を入力してください");
					dispatcher.forward(request, response);
				}

			} catch (NumberFormatException n) {
				// 集計入力画面にフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/counts.jsp");
				request.setAttribute("erro", "数字を入力してください");
				dispatcher.forward(request, response);
			}

			finally {
				//CountSortingServletサーブレットに処理を渡す(リダイレクト)
				response.sendRedirect("/sante/CountsSortingServlet");
			}

		}
	}

}