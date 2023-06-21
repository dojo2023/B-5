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
	    String users_name = request.getParameter("users_name");
	    String users_password = request.getParameter("users_password");

	    // 生年月日を一つの整数にまとめる
	    int year = Integer.parseInt(request.getParameter("year"));
	    int month = Integer.parseInt(request.getParameter("month"));
	    int day = Integer.parseInt(request.getParameter("day"));

	    int birthday = year * 10000 + month * 100 + day;
	    // birthdayをString型に変換してusers_birthdayに格納する
	    String users_birthday = String.valueOf(birthday);

        // DAOのメソッドを呼び出してニックネームとパスワードをデータベースに挿入
        UsersDAO UsersDAO = new UsersDAO();
        boolean registrationSuccess = UsersDAO.InsertUser(new Users(0,users_name, users_password, users_birthday, null, null));

        if (registrationSuccess) {
            // 登録成功時の処理
        	request.getAttribute("/sante/RegistManualServlet");
        } else {
            // 登録失敗時の処理
            request.setAttribute("message", "ニックネームとパスワードの登録に失敗しました");
            // メッセージを含めてregister.jspにフォワードする
            request.getRequestDispatcher("/WEB-INF/jsp/usersresult.jsp").forward(request, response);
        }

    }
}
