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
		int check = 0;
		String URI = "";
		// 次へまたはキャンセルを行う
		request.setCharacterEncoding("UTF-8");
		ArrayList<String> name_list = new ArrayList<String>();
		ArrayList<String> birthday_list = new ArrayList<String>();
		PostCounts post_counts = (PostCounts) session.getAttribute("post_counts");
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

					
					
					//session.setAttribute("post_counts", counts_name);
					session.setAttribute("nameList", name_list);
					


					
				}
				post_counts.setName_list(name_list);

			}
			//入力されたid,brithdayが一致したら
			int name_count = 0;
			String bi = "";
			ArrayList<Integer>ids = new ArrayList<>();
			for (String na : name_list) {
				bi = birthday_list.get(name_count);

				UsersDAO uDao = new UsersDAO();
				int users_id = uDao.getUserIDCounts(na, bi);
				if (users_id == -1) {
					System.out.println("fail");
					request.setAttribute("erro", "一致しません");
					doGet(request,response);
				}
				ids.add(users_id);
				name_count++;

			}
			for (int i=0;i<name_list.size();i++) {
			System.out.println(name_list.get(i));
			System.out.println(ids.get(i));
			}
			//成功。サーブレット移動
			System.out.println("success");
			post_counts.setId_list(ids);
			session.setAttribute("ids", ids);
//			session.setAttribute("nameList", name_list);

			
			session.setAttribute("post_counts", post_counts);
			System.out.println(name_list);
			System.out.println(birthday_list);

			//DBでname,birthday_listを使ってSelect文であるかどうかをチェック
			if(URI.equals("") ){
			//次のサーブレットにリダイレクト
			response.sendRedirect("/sante/CountsCupsServlet");
			}else {
				response.sendRedirect(URI);

			}
		} else {
			//キャンセル元のサーブレットにもどる。
			response.sendRedirect("/sante/CountsSortingServlet");
		}

	}

}
