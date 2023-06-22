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
 * Servlet implementation class CountsUsersRegistServlet
 */
@WebServlet("/CountsUsersRegistServlet")
public class CountsUsersRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
				HttpSession session = request.getSession();
/*				if (session.getAttribute("id") == null) {
					response.sendRedirect("/sante/LoginServlet");
					return;
				}
*/				
				// アプリ利用者登録画面にフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/countsusersregist.jsp");
				dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
			HttpSession session = request.getSession();
/*			if (session.getAttribute("id") == null) {
				response.sendRedirect("/sante/LoginServlet");
				return;
				}
*/
		
		// 次へまたはキャンセルを行う
			request.setCharacterEncoding("UTF-8");
			if (request.getParameter("submit").equals("次へ")) {
				
				for(int i=0;i<10;i++) {
				
				String users_name = request.getParameter("name"+i);
				System.out.println(users_name);
				// 生年月日を一つの整数にまとめる
			    int year = Integer.parseInt(request.getParameter("year"+i));
			    int month = Integer.parseInt(request.getParameter("month"+i));
			    int day = Integer.parseInt(request.getParameter("day"+i));

			    int birthday = year * 10000 + month * 100 + day;
			    // birthdayをString型に変換してusers_birthdayに格納する
			    String users_birthday = String.valueOf(birthday);
			    System.out.println(users_birthday);
			    //users_name,users_birthdayのデータがdbにあるかチェックする
			    
			    
			    //あれば次をやる
			    
			    //なければエラーでdoGetをやり直す
			    
			    
				}
				
			  //セッションスコープから「post_counts」のインスタンスを取り出し、PostCounts型にキャスタ(型変換)
				PostCounts counts_name = (PostCounts)session.getAttribute("post_counts");
				PostCounts counts_birthday = (PostCounts)session.getAttribute("post_counts");
				
				
			
				// 投稿情報を格納
				counts_name.setUsers_name0(users_name0);
				counts_name.setUsers_name1(users_name1);
				counts_name.setUsers_name2(users_name2);
				counts_name.setUsers_name3(users_name3);
				counts_name.setUsers_name4(users_name4);
				counts_name.setUsers_name5(users_name5);
				counts_name.setUsers_name6(users_name6);
				counts_name.setUsers_name7(users_name7);
				counts_name.setUsers_name8(users_name8);
				counts_name.setUsers_name9(users_name9);

				counts_birthday.setUsers_birthday0(users_birthday0);
				counts_birthday.setUsers_birthday1(users_birthday1);
				counts_birthday.setUsers_birthday2(users_birthday2);
				counts_birthday.setUsers_birthday3(users_birthday3);
				counts_birthday.setUsers_birthday4(users_birthday4);
				counts_birthday.setUsers_birthday5(users_birthday5);
				counts_birthday.setUsers_birthday6(users_birthday6);
				counts_birthday.setUsers_birthday7(users_birthday7);
				counts_birthday.setUsers_birthday8(users_birthday8);
				counts_birthday.setUsers_birthday9(users_birthday9);
				
		
				session.setAttribute("post_counts",counts_name );
				session.setAttribute("post_counts",counts_birthday );
				
				

			//次のサーブレットにリダイレクト
			response.sendRedirect("/sante/CountsCupsServlet");
		}else {
			//キャンセル元のサーブレットにもどる。
			response.sendRedirect("/sante/CountsSortingServlet");
		}		
		
	}

}
