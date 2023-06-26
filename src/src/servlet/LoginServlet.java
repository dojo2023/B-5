package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsersDAO;
import model.LoginId;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ログインページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String users_name = request.getParameter("users_name");
		String users_password = request.getParameter("users_password");

		UsersDAO iDao = new UsersDAO();
		int users_id = iDao.getUserID(users_name, users_password);

	    if (users_id != -1) { // Valid users_id retrieved
	    	// セッションスコープにusers_idを格納する
	        HttpSession session = request.getSession();
	        session.setAttribute("users_id", new LoginId(users_id));
	        // メニューサーブレットにリダイレクトする
	        response.sendRedirect("/sante/CalendarServlet");
	    } else {
	        request.setAttribute("message", "ニックネームまたはパスワードに間違いがあります。");
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/usersresult.jsp");
	        dispatcher.forward(request, response);
	    }


		// ログイン処理を行う

//		if (iDao.isLoginOK(new Users(users_id,users_name, users_password,null,null,null))) {	// ログイン成功
//			// セッションスコープにusers_nameを格納する
//			HttpSession session = request.getSession();
//			session.setAttribute("users_id", new LoginId(users_id));
//
//			// メニューサーブレットにリダイレクトする
//			response.sendRedirect("/sante/CountServlet");
//		}
//		else {									// ログイン失敗
//			// リクエストスコープに、タイトル、メッセージ、戻り先を格納する
////			request.setAttribute("result",
////			new Result("ログイン失敗！", "ニックネームまたはパスワードに間違いがあります。", "/sante/LoginServlet"));
//			request.setAttribute("message", "ニックネームまたはパスワードに間違いがあります。");
//			// 結果ページにフォワードする
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/usersresult.jsp");
//			dispatcher.forward(request, response);
//		}
	}
}
