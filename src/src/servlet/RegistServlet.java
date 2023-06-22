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
import model.Users;

@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// registページにフォワードする
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

	    // Check if the user is under 20 years old
	    if (isUnderage(year, month, day)) {
	        // 登録失敗時の処理
	        request.setAttribute("message", "20歳未満の方は登録できません");
	        // メッセージを含めてregister.jspにフォワードする
	        request.getRequestDispatcher("/WEB-INF/jsp/usersresult.jsp").forward(request, response);
	        return;
	    }

	    // DAOのメソッドを呼び出してニックネームとパスワードをデータベースに挿入
	    UsersDAO usersDAO = new UsersDAO();
		int users_id = usersDAO.getUserID(users_name, users_password);

	    if (users_id != -1) { // Valid users_id retrieved
	    	boolean registrationSuccess = usersDAO.InsertUser(new Users(0, users_name, users_password, users_birthday, null, null));

		    if (registrationSuccess) {
		        // 登録成功時の処理
		        response.sendRedirect("/sante/RegistManualServlet");
		        // セッションスコープにusers_idを格納する
		        HttpSession session = request.getSession();
		        session.setAttribute("users_id", new LoginId(users_id));
		        // メニューサーブレットにリダイレクトする
		        response.sendRedirect("/sante/CountsServlet");
		    } else {
		        // 登録失敗時の処理
		        request.setAttribute("message", "ニックネームとパスワードの登録に失敗しました");
		        // メッセージを含めてregister.jspにフォワードする
		        request.getRequestDispatcher("/WEB-INF/jsp/usersresult.jsp").forward(request, response);
		    }
	    }else {
	    	// 登録失敗時の処理
	        request.setAttribute("message", "ニックネームは既に登録しました");
	        // メッセージを含めてregister.jspにフォワードする
	        request.getRequestDispatcher("/WEB-INF/jsp/usersresult.jsp").forward(request, response);
	    }

	}

	private boolean isUnderage(int year, int month, int day) {
	    // 年月日を計算
	    java.util.Calendar now = java.util.Calendar.getInstance();
	    int currentYear = now.get(java.util.Calendar.YEAR);
	    int currentMonth = now.get(java.util.Calendar.MONTH) + 1;
	    int currentDay = now.get(java.util.Calendar.DAY_OF_MONTH);

	    // 20歳未満かどうか確認
	    if (currentYear - year < 20) {
	        return true; // ユーザは２０以下
	    } else if (currentYear - year == 20) {
	        if (currentMonth < month) {
	            return true; // ユーザは２０以下
	        } else if (currentMonth == month && currentDay < day) {
	            return true; // ユーザは２０以下
	        }
	    }

	    return false; // ユーザは２０歳以上
	}

}
