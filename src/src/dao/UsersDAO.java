package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Users;

public class UsersDAO {
	// ログインできるならtrueを返す
	public boolean isLoginOK(Users users) {
		Connection conn = null;
		boolean loginResult = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/B5", "yasuo", "yasuo");

			// SELECT文を準備する
			String sql = "select count(*) from users where users_name = ? and users_password = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,users.getUsers_name());
			pStmt.setString(2,users.getUsers_password());

			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// ユーザーニックネームとパスワードが一致するユーザーがいたかどうかをチェックする
			rs.next();
			if (rs.getInt("count(*)") == 1) {
				loginResult = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			loginResult = false;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			loginResult = false;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					loginResult = false;
				}
			}
		}

		// 結果を返す
		return loginResult;
	}

	public boolean InsertUser(Users users) {
	    Connection conn = null;
	    boolean updateSuccess = false;
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/B5", "yasuo", "yasuo");

			// Prepare the SQL statement
	        String sql = "INSERT INTO users (users_name, users_password, users_birthday) VALUES (?, ?, ?)";
	        PreparedStatement pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, users.getUsers_name());
	        pstmt.setString(2, users.getUsers_password());
	        pstmt.setString(3, users.getUsers_birthday());

	        // Execute the update statement
	        pstmt.executeUpdate();

	        // The update was successful
	        updateSuccess = true;

	        pstmt.close();

	    } catch (SQLException | ClassNotFoundException e) {
	        e.printStackTrace();
	    } finally {
	        if (conn != null) {
	            try {
	                conn.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    return updateSuccess;
	}

	public int getUserID(String users_name, String users_password) {
	    Connection conn = null;
	    int userID = -1; // Initialize with an invalid value

	    try {
	    	// JDBCドライバを読み込む
	    	Class.forName("org.h2.Driver");

	    	// データベースに接続する
	    	conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/B5", "yasuo", "yasuo");


	        String sql = "SELECT users_id FROM users WHERE users_name = ? AND users_password = ?";
	        PreparedStatement pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, users_name);
	        pstmt.setString(2, users_password);

	        ResultSet rs = pstmt.executeQuery();
	        if (rs.next()) {
	            userID = rs.getInt("users_id");
	        }
	    } catch (SQLException | ClassNotFoundException e) {
	        e.printStackTrace();
	    } finally {
	        if (conn != null) {
	            try {
	                conn.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    return userID;
	}

	public int getMaxUserID() {
	    Connection conn = null;
	    int maxUserID = -1; // Initialize with an invalid value

	    try {
	        // JDBCドライバを読み込む
	        Class.forName("org.h2.Driver");

	        // データベースに接続する
	        conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/B5", "yasuo", "yasuo");

	        String sql = "SELECT MAX(users_id) AS max_id FROM users";
	        Statement stmt = conn.createStatement();

	        ResultSet rs = stmt.executeQuery(sql);
	        if (rs.next()) {
	            maxUserID = rs.getInt("max_id");
	        }
	    } catch (SQLException | ClassNotFoundException e) {
	        e.printStackTrace();
	    } finally {
	        if (conn != null) {
	            try {
	                conn.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    return maxUserID;
	}


}


