package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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
	        String sql = "INSERT INTO schedules ( schedules_name, schedules_dt, users_id) VALUES ( ?, ?, ?)";
	        PreparedStatement pstmt = conn.prepareStatement(sql);
	        //pstmt.setInt(1, schedules.getSchedules_id());
	        pstmt.setString(1, schedules.getSchedules_name());
	        pstmt.setTimestamp(2, schedules.getSchedules_dt());
	        pstmt.setInt(3, schedules.getUsers_id());


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
	public List<Schedules> getAllSchedules(int users_id) {
	    Connection conn = null;
	    List<Schedules> schedulesList = new ArrayList<>();

	    try {
	        // JDBCドライバを読み込むs
	        Class.forName("org.h2.Driver");

	        // データベースに接続する
	        conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/B5", "yasuo", "yasuo");

	        String sql = "SELECT * FROM schedules WHERE users_id = ?";
	        PreparedStatement pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1,users_id);


	        ResultSet rs = pstmt.executeQuery();
	        while (rs.next()) {
	        	Schedules sg = new Schedules();
	        	sg.setSchedules_id(rs.getInt("schedules_id"));
	            String schedules_name = rs.getString("schedules_name");
	            Timestamp schedules_dt = rs.getTimestamp("schedules_dt");
	            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	            String schedules_dt_str = sdf.format(schedules_dt);
	            String schedules_date = schedules_dt_str.substring(0,10);
	            String schedules_time = schedules_dt_str.substring(11,19);

	            sg.setSchedules_name(schedules_name);
	            sg.setSchedules_date(schedules_date);
	            sg.setSchedules_time(schedules_time);
	            schedulesList.add(sg);
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

	// schedulesを削除
	public boolean deleteSchedules(int schedules_id) {
	    Connection conn = null;
	    boolean deleteSuccess = false;

	    try {
	        // JDBCドライバを読み込む
	        Class.forName("org.h2.Driver");

	        // データベースに接続する
	        conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/B5", "yasuo", "yasuo");

	        // Prepare the SQL statement
	        String sql = "DELETE FROM schedules WHERE schedules_id = ?";
	        PreparedStatement pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, schedules_id);

	        // Execute the update statement
	        int rowsAffected = pstmt.executeUpdate();

	        if (rowsAffected > 0) {
	            // The delete was successful
	            deleteSuccess = true;
	        }

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

	    return deleteSuccess;
	}

	// schedulesを更新
	public boolean updateSchedules(Schedules schedules) {
	    Connection conn = null;
	    boolean updateSuccess = false;

	    try {
	        // JDBCドライバを読み込む
	        Class.forName("org.h2.Driver");

	        // データベースに接続する
	        conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/B5", "yasuo", "yasuo");

	        // Prepare the SQL statement
	        String sql = "UPDATE schedules SET schedules_name = ?, schedules_dt = ? WHERE schedules_id = ?";
	        PreparedStatement pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, schedules.getSchedules_name());
	        pstmt.setTimestamp(2, schedules.getSchedules_dt());
	        pstmt.setInt(3, schedules.getSchedules_id());

	        // Execute the update statement
	        int rowsAffected = pstmt.executeUpdate();

	        if (rowsAffected > 0) {
	            // The update was successful
	            updateSuccess = true;
	        }

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

	// スケジュールのIDを取得
	public int getSchedulesId(Timestamp dt) {
	    Connection conn = null;
	    int schedulesId = -1;

	    try {
	        // JDBCドライバを読み込む
	        Class.forName("org.h2.Driver");

	        // データベースに接続する
	        conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/B5", "yasuo", "yasuo");

	        String sql = "SELECT schedules_id FROM schedules WHERE schedules_dt = ?";
	        PreparedStatement pstmt = conn.prepareStatement(sql);

	        pstmt.setTimestamp(1, dt);

	        ResultSet rs = pstmt.executeQuery();
	        if (rs.next()) {
	            schedulesId = rs.getInt("schedules_id");
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

	    return schedulesId;
	}


}
