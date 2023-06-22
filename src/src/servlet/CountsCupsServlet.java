package servlet;

import java.io.IOException;

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
/*		if (session.getAttribute("id") == null) {
			response.sendRedirect("/sante/LoginServlet");
			return;
		}
*/
		
		
		// 杯数選択画面にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/countscups.jsp");
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
//			Drinks dr = new Drinks(3,3,4,3);
//			session.setAttribute("dinrks", dr);
			
			request.setCharacterEncoding("UTF-8");
			if (request.getParameter("submit").equals("登録")) {
				
			//作成中です
				//	int counts = Integer.parseInt(request.getParameter("counts"));
				
				
				//集計登録確認画面のサーブレットにリダイレクト
				response.sendRedirect("/sante/CountsRegistConfirmServlet");
				
				
					
			}
			else if (request.getParameter("submit").equals("割合表示")) {
				//割合画面のサーブレットにリダイレクト
				response.sendRedirect("/sante/CountsRatioServlet");
			}
		
	}

}
