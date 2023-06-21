package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Bookmarks;

public class BookmarksDAO {
	// bookmarksに格納
	public boolean insertBookmarks(Bookmarks bookmarks) {
	    Connection conn = null;
	    boolean insertSuccess = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/B5", "yasuo", "yasuo");

			// Prepare the SQL statement
	        String sql = "INSERT INTO bookmarks (bookmarks_id, libraries_id, users_id, bookmarks_remarks) VALUES (?, ?, ?, ?)";
	        PreparedStatement pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, bookmarks.getBookmarks_id());
	        pstmt.setInt(2, bookmarks.getLibraries_id());
	        pstmt.setInt(3, bookmarks.getUsers_id());
	        pstmt.setString(4, bookmarks.getBookmarks_remarks());

	        // Execute the update statement
	        pstmt.executeUpdate();

	        // The update was successful
	        insertSuccess = true;

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

	    return insertSuccess;
	}

	// bookmarksを取得
	public List<Bookmarks> getAllBookmarks() {
	    Connection conn = null;
	    List<Bookmarks> bookmarksList = new ArrayList<>();

	    try {
	        // JDBCドライバを読み込むs
	        Class.forName("org.h2.Driver");

	        // データベースに接続する
	        conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/B5", "yasuo", "yasuo");

	        String sql = "SELECT * FROM bookmarks WHERE bookmarks_id = ?";
	        PreparedStatement pstmt = conn.prepareStatement(sql);

	        ResultSet rs = pstmt.executeQuery();
	        while (rs.next()) {
	            int bookmarks_id = rs.getInt("bookmarks_id");
	            int libraries_id = rs.getInt("libraries_id");
	            int users_id = rs.getInt("users_id");
	            String bookmarks_remarks = rs.getString("bookmarks_remarks");


	            // bookmarksオブジェクトを作成してリストに追加
	            Bookmarks bookmarks = new Bookmarks(bookmarks_id, libraries_id, users_id, bookmarks_remarks, null, null);
	            bookmarksList.add(bookmarks);
	        }

	        pstmt.close();
	        rs.close();
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

	    return bookmarksList;
	}


}
