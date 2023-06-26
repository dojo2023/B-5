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

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	// もしもログインしていなかったらログインサーブレットにリダイレクトする。
		HttpSession session = request.getSession();
		if (session.getAttribute("users_id") == null) {
			System.out.println("ログイン失敗");
			response.sendRedirect("/sante/LoginServlet");
			return;
		}
        // Forward to the regist.jsp page
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/regist.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	// もしもログインしていなかったらログインサーブレットにリダイレクトする。
		HttpSession session = request.getSession();
		if (session.getAttribute("users_id") == null) {
			System.out.println("ログイン失敗");
			response.sendRedirect("/sante/LoginServlet");
			return;
		}
        // Retrieve request parameters
        request.setCharacterEncoding("UTF-8");
        String users_name = request.getParameter("users_name");
        String users_password = request.getParameter("users_password");

        // Combine the birth year, month, and day into a single integer
        int year = Integer.parseInt(request.getParameter("year"));
        int month = Integer.parseInt(request.getParameter("month"));
        int day = Integer.parseInt(request.getParameter("day"));

        int birthday = year * 10000 + month * 100 + day;
        String users_birthday = String.valueOf(birthday);

        // Check if the user is underage
        if (isUnderage(year, month, day)) {
            // Registration failed due to age restriction
            request.setAttribute("message", "20歳未満の方は登録できません");
            request.getRequestDispatcher("/WEB-INF/jsp/usersresult.jsp").forward(request, response);
            return;
        }

        // Check if the nickname is already registered
        UsersDAO usersDAO = new UsersDAO();
        boolean registResult = usersDAO.registCheck(users_name);

        if (!registResult) {
            // Registration failed due to duplicate nickname
            request.setAttribute("message", "ニックネームは既に登録されています");
            request.getRequestDispatcher("/WEB-INF/jsp/usersresult.jsp").forward(request, response);
            return;
        }

        // Insert the user into the database
        boolean registrationSuccess = usersDAO.InsertUser(new Users(0, users_name, users_password, users_birthday, null, null));

        if (registrationSuccess) {
            // Registration successful
            response.sendRedirect("/sante/RegistManualServlet");
            // Retrieve the generated users_id
            int users_id = usersDAO.getUserID(users_name, users_password);
            // Store users_id in the session scope
            session.setAttribute("users_id", new LoginId(users_id));
        } else {
            // Registration failed
            request.setAttribute("message", "ニックネームとパスワードの登録に失敗しました");
            request.getRequestDispatcher("/WEB-INF/jsp/usersresult.jsp").forward(request, response);
        }
    }

    private boolean isUnderage(int year, int month, int day) {
        // Calculate the current date
        java.util.Calendar now = java.util.Calendar.getInstance();
        int currentYear = now.get(java.util.Calendar.YEAR);
        int currentMonth = now.get(java.util.Calendar.MONTH) + 1;
        int currentDay = now.get(java.util.Calendar.DAY_OF_MONTH);

        // Check if the user is under 20 years old
        if (currentYear - year < 20) {
            return true;
        } else if (currentYear - year == 20) {
            if (currentMonth < month) {
                return true;
            } else if (currentMonth == month && currentDay < day) {
                return true;
            }
        }

        return false;
    }
}
