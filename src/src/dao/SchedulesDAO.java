package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import model.Schedules;

public class SchedulesDAO {
	// Schedulesに格納
	public boolean insertSchedules(Schedules schedules) {
	    Connection conn = null;
	    boolean insertSuccess = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/B5", "yasuo", "yasuo");

			// Prepare the SQL statement
	        String sql = "INSERT INTO schedules (schedules_id, schedules_name, schedules_dt, users_id) VALUES (?, ?, ?, ?)";
	        PreparedStatement pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, schedules.getSchedules_id());
	        pstmt.setString(2, schedules.getSchedules_name());
	        pstmt.setTimestamp(3, schedules.getSchedules_dt());
	        pstmt.setInt(4, schedules.getUsers_id());


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

	// schedulesを取得
	public List<Schedules> getAllSchedules() {
	    Connection conn = null;
	    List<Schedules> schedulesList = new ArrayList<>();

	    try {
	        // JDBCドライバを読み込むs
	        Class.forName("org.h2.Driver");

	        // データベースに接続する
	        conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/B5", "yasuo", "yasuo");

	        String sql = "SELECT * FROM schedules WHERE schedules_id = ?";
	        PreparedStatement pstmt = conn.prepareStatement(sql);

	        ResultSet rs = pstmt.executeQuery();
	        while (rs.next()) {
	            int schedules_id = rs.getInt("schedules_id");
	            String schedules_name = rs.getString("schedules_name");
	            Timestamp schedules_dt = rs.getTimestamp("schedules_dt");
	            int users_id = rs.getInt("users_id");


	            // schedulesオブジェクトを作成してリストに追加
	            Schedules schedules = new Schedules(schedules_id, schedules_name, schedules_dt, users_id, null, null);
	            schedulesList.add(schedules);
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

	    return schedulesList;
	}


}
