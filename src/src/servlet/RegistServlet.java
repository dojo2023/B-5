package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsersDAO;
import model.Users;

@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ログインページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/regist.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String users_id 
		String users_name = request.getParameter("users_name");
		String users_password = request.getParameter("users_password");
		String users_birthday = request.getParameter("users_birthday");
        // DAOのメソッドを呼び出してニックネームとパスワードをデータベースに挿入
        UsersDAO UsersDAO = new UsersDAO();
        boolean registrationSuccess = UsersDAO.InsertUser(new Users(users_id,users_name, users_password,users_birthday));

        if (registrationSuccess) {
            // 登録成功時の処理
            request.setAttribute("message", "ニックネームとpasswordを登録しました");
        } else {
            // 登録失敗時の処理
            request.setAttribute("message", "ニックネームとpasswordの登録に失敗しました");
        }

        // メッセージを含めてregister.jspにフォワードする
        request.getRequestDispatcher("/WEB-INF/jsp/usersresult.jsp").forward(request, response);
    }
}
