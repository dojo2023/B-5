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

import dao.CountsDAO;
import model.PostCounts;

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

		ArrayList<Integer> counts_list = new ArrayList<Integer>();

		PostCounts post_counts = (PostCounts) session.getAttribute("post_counts");

		if (request.getParameter("submit").equals("登録")) {

			//			for (int i = 1; i < 11; i++) {
			//				if (request.getParameter("counts_cups" + i) != null) {
			//					System.out.println(request.getParameter("counts_cups" + i));
			//					System.out.println("counts_cups" + i);

			//					String user_id = request.getParameter("ids" + i);
System.out.println(post_counts.getAll_member());
			for (int i = 0; i < post_counts.getAll_member(); i++) {
				String counts_cups = request.getParameter("counts_cups" + i);
				int counts_cups_int = Integer.parseInt(counts_cups);
				counts_list.add(i, counts_cups_int);
			}

			post_counts.setCounts_list(counts_list);

			//idがuser_id、飲んだ杯数がcounts_cupsをinsertするdaoを呼び出してテーブルに挿入する

			CountsDAO cDao = new CountsDAO();

			//					Counts count = new Counts();
			//					count.setUsers_id(Integer.parseInt(user_id));
			//					count.setCounts_alcohol(Integer.parseInt(counts_cups));

			for (int i = 0; i < post_counts.getUsers_member(); i++) {
				if (cDao.insertCounts(post_counts.getId_list().get(i), post_counts.getCounts_list().get(i))) {

				} else {
					System.out.println("fail");
				}
			}
			//					counts_list.add(counts_cups);
			//				}
			//			}

			//			session.setAttribute("counts_list", counts_list);

			//			System.out.println(counts_list);

			//集計登録確認画面のサーブレットにリダイレクト
			response.sendRedirect("/sante/CountsRegistConfirmServlet");

		} else if (request.getParameter("submit").equals("割合表示")) {
			//割合画面のサーブレットにリダイレクト
			
			for (int i = 0; i < post_counts.getAll_member(); i++) {
				String counts_cups = request.getParameter("counts_cups" + i);
				int counts_cups_int = Integer.parseInt(counts_cups);
				counts_list.add(i, counts_cups_int);
			}

			post_counts.setCounts_list(counts_list);
			response.sendRedirect("/sante/CountsRatioServlet");
		}

	}

}
