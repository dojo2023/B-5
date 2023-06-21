package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Libraries;

public class LibrariesDAO {
	// Librariesに格納
	public boolean insertLibraries(Libraries libraries) {
	    Connection conn = null;
	    boolean insertSuccess = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/B5", "yasuo", "yasuo");

			// Prepare the SQL statement
	        String sql = "INSERT INTO libraries (libraries_id, libraries_description, libraries_genre, libraries_kind, libraries_alcon, libraries_from, libraries_remarks, libraries_public) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	        PreparedStatement pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, libraries.getLibraries_id());
	        pstmt.setString(2, libraries.getLibraries_description());
	        pstmt.setString(3, libraries.getLibraries_genre());
	        pstmt.setString(4, libraries.getLibraries_kind());
	        pstmt.setDouble(5, libraries.getLibraries_alcon());
	        pstmt.setString(6, libraries.getLibraries_from());
	        pstmt.setString(7, libraries.getLibraries_remarks());
	        pstmt.setBoolean(8, libraries.isLibraries_public());


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

	// librariesを取得
	public List<Libraries> getAllLibraries() {
	    Connection conn = null;
	    List<Libraries> librariesList = new ArrayList<>();

	    try {
	        // JDBCドライバを読み込むs
	        Class.forName("org.h2.Driver");

	        // データベースに接続する
	        conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/B5", "yasuo", "yasuo");

	        String sql = "SELECT * FROM libraries WHERE libraries_id = ?";
	        PreparedStatement pstmt = conn.prepareStatement(sql);

	        ResultSet rs = pstmt.executeQuery();
	        while (rs.next()) {
	            int libraries_id = rs.getInt("libraries_id");
	            String libraries_description = rs.getString("libraries_description");
	            String libraries_genre = rs.getString("libraries_genre");
	            String libraries_kind = rs.getString("llibraries_kind");
	            Double libraries_alcon = rs.getDouble("libraries_alcon");
	            String libraries_from = rs.getString("libraries_from");
	            String libraries_remarks = rs.getString("libraries_remarks");
	            Boolean libraries_public = rs.getBoolean("libraries_public");




	            // librariesオブジェクトを作成してリストに追加
	            Libraries libraries = new Libraries(libraries_id, libraries_description, libraries_genre, libraries_kind, libraries_alcon, libraries_from, libraries_remarks, libraries_public, null, null);
	            librariesList.add(libraries);
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

	    return librariesList;
	}


}
