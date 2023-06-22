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
 * Servlet implementation class CountsSortingServlet
 */
@WebServlet("/CountsSortingServlet")
public class CountsSortingServlet extends HttpServlet {
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
				// アプリ利用者選別画面にフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/countssorting.jsp");
				dispatcher.forward(request, response);
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
/*		if (session.getAttribute("id") == null) {
			response.sendRedirect("/sante/LoginServlet");
			return;
		}
*/		

		// 次へまたはキャンセルを行う
		request.setCharacterEncoding("UTF-8");
		if (request.getParameter("submit").equals("次へ")) {
			try {
				int users_member = Integer.parseInt(request.getParameter("userscounts"));
			
				if (users_member != 0) {
					//セッションスコープから「post_counts」のインスタンスを取り出し、PostCounts型にキャスタ(型変換)
					PostCounts pcs = (PostCounts)session.getAttribute("post_counts");

					//pcからall_memberの値を取り出すゲッターメソッドを実行する
					int allmem = pcs.getAll_member();

					
					
					if(users_member>allmem) {
						//エラー処理
						// アプリ利用者選別画面にフォワードする
						RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/countssorting.jsp");
						dispatcher.forward(request, response);
					}else {
						PostCounts counts_data = (PostCounts)session.getAttribute("post_counts");
						// 投稿情報を格納
						counts_data.setUsers_member(users_member);
						
						session.setAttribute("post_counts",counts_data );
						
						if (users_member < 0) {
							// アプリ利用者選別画面にフォワードする
							RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/countssorting.jsp");
							dispatcher.forward(request, response);
						}
						else if (users_member > 10) {
							// アプリ利用者選別画面にフォワードする
							RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/countssorting.jsp");
							dispatcher.forward(request, response);
						}
						
					}

				}
				else if (users_member == 0) {
					// アプリ利用者選別画面にフォワードする
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/countssorting.jsp");
					dispatcher.forward(request, response);
				}
			}
			catch(NumberFormatException n) {
				// アプリ利用者選別画面にフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/countssorting.jsp");
				dispatcher.forward(request, response);
			}
			finally {
				//CountSortingServletサーブレットに処理を渡す(リダイレクト)
				response.sendRedirect("/sante/CountsUsersRegistServlet");
			}
		}
	}
}
