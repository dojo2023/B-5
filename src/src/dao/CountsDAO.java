package dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Counts;
public class CountsDAO {
	// Countsに格納
	public boolean insertCounts(Counts counts) {
	    Connection conn = null;
	    boolean insertSuccess = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/B5", "yasuo", "yasuo");

			// Prepare the SQL statement
	        String sql = "INSERT INTO counts (users_id, counts_alcohol, counts_date) VALUES (?, ?, ?)";
	        PreparedStatement pstmt = conn.prepareStatement(sql);
//	        pstmt.setInt(1, counts.getCounts_id());
	        pstmt.setInt(1, counts.getUsers_id());
	        pstmt.setInt(2, counts.getCounts_alcohol());
	        
	        pstmt.setString(3,"current_date");


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

	// countsを取得
	public List<Counts> getAllCounts() {
	    Connection conn = null;
	    List<Counts> countsList = new ArrayList<>();

	    try {
	        // JDBCドライバを読み込むs
	        Class.forName("org.h2.Driver");

	        // データベースに接続する
	        conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/B5", "yasuo", "yasuo");

	        String sql = "SELECT * FROM counts WHERE counts_id = ?";
	        PreparedStatement pstmt = conn.prepareStatement(sql);

	        ResultSet rs = pstmt.executeQuery();
	        while (rs.next()) {
	            int counts_id = rs.getInt("counts_id");
	            int users_id = rs.getInt("users_id");
	            int counts_alcohol = rs.getInt("counts_alcohol");
	            Date counts_date = rs.getDate("counts_date");


	            // countsオブジェクトを作成してリストに追加
	            Counts counts = new Counts(counts_id, users_id, counts_alcohol, counts_date, null, null);
	            countsList.add(counts);
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

	    return countsList;
	}


}
