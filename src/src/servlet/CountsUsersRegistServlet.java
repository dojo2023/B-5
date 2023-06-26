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

import dao.UsersDAO;
import model.PostCounts;

/**
 * Servlet implementation class CountsUsersRegistServlet
 */
@WebServlet("/CountsUsersRegistServlet")
public class CountsUsersRegistServlet extends HttpServlet {
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
		// アプリ利用者登録画面にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/countsusersregist.jsp");
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

		// 次へまたはキャンセルを行う
		request.setCharacterEncoding("UTF-8");
		ArrayList<String> name_list = new ArrayList<String>();
		ArrayList<String> birthday_list = new ArrayList<String>();
		if (request.getParameter("submit").equals("次へ")) {

			for (int i = 1; i < 11; i++) {

				if (request.getParameter("name" + i) != null) {
					//					System.out.println(request.getParameter("name" + i));
					//					System.out.println("name" + i);
					String name = request.getParameter("name" + i);
					// 生年月日を一つの整数にまとめる
					int year = Integer.parseInt(request.getParameter("year" + i));
					int month = Integer.parseInt(request.getParameter("month" + i));
					int day = Integer.parseInt(request.getParameter("day" + i));

					int birthday = year * 10000 + month * 100 + day;
					// birthdayをString型に変換してusers_birthdayに格納する

					String users_birthday = String.valueOf(birthday);

					//					System.out.println(users_birthday);
					//users_name,users_birthdayのデータがdbにあるかチェックする

					name_list.add(name);

					birthday_list.add(users_birthday);

					PostCounts counts_name = (PostCounts) session.getAttribute("post_counts");
					counts_name.setName_list(name_list);
					session.setAttribute("post_counts", counts_name);
					session.setAttribute("nameList", name_list);



				}

				//あれば次をやる

				//なければエラーでdoGetをやり直す

			}
			//入力されたid,brithdayが一致したら
			int name_count = 0;
			String bi = "";
			for (String na : name_list) {
				bi = birthday_list.get(name_count);

				UsersDAO uDao = new UsersDAO();
				int id_count = uDao.getUserIDCounts(na, bi);
				if (id_count == -1) {
					System.out.println("fail");
					
				}
				name_count++;

			}
			//成功。サーブレット移動
			System.out.println("success");
//			session.setAttribute("nameList", name_list);

			System.out.println(name_list);
			System.out.println(birthday_list);

			//DBでname,birthday_listを使ってSelect文であるかどうかをチェック

//			session.setAttribute("nameList", name_list);

//			System.out.println(name_list);
//			System.out.println(birthday_list);

			//DBでname,birthday_listを使ってSelect文であるかどうかをチェック

			//次のサーブレットにリダイレクト
			response.sendRedirect("/sante/CountsCupsServlet");
		} else {
			//キャンセル元のサーブレットにもどる。
			response.sendRedirect("/sante/CountsSortingServlet");
		}

	}

}
