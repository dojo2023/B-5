package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Drinks;

/**
 * Servlet implementation class CountsCupsServlet
 */
@WebServlet("/CountsCupsServlet")
public class CountsCupsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
/*		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
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
//		if (session.getAttribute("id") == null) {
//			response.sendRedirect("/sante/LoginServlet");
//			return;
//		}
		
		// 検索処理を行う
//			CountsDAO cDao = new CountsDAO();
//			List<Counts> cardList = cDao.select(new Counts(counts));
			Drinks dr = new Drinks(3,3,4,3);
			session.setAttribute("dinrks", dr);
				
			if (request.getParameter("SUBMIT").equals("登録")) {
				//次のサーブレットにリダイレクト
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/countsregistconfirm.jsp");
				dispatcher.forward(request, response);
					
			}
			else if (request.getParameter("SUBMIT").equals("割合表示")){
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/countsratio.jsp");
				dispatcher.forward(request, response);
			}
				
				
		// 割合表示画面にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/countsregistconfirm.jsp");
		dispatcher.forward(request, response);
	}

}
