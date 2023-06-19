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
import model.LoginUser;
import model.Users;

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

		// ログイン処理を行う
		UsersDAO iDao = new UsersDAO();
		if (iDao.isLoginOK(new Users(0,users_name, users_password,null,null,null))) {	// ログイン成功
			// セッションスコープにusers_nameを格納する
			HttpSession session = request.getSession();
			session.setAttribute("users_name", new LoginUser(users_name));

			// メニューサーブレットにリダイレクトする
			response.sendRedirect("/sante/CalendarServlet");
		}
		else {									// ログイン失敗
			// リクエストスコープに、タイトル、メッセージ、戻り先を格納する
//			request.setAttribute("result",
//			new Result("ログイン失敗！", "ニックネームまたはパスワードに間違いがあります。", "/sante/LoginServlet"));
			request.setAttribute("message", "ニックネームまたはパスワードに間違いがあります。");
			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/usersresult.jsp");
			dispatcher.forward(request, response);
		}
	}
}
