package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Physicals;

public class PhysicalsDAO {
	// physicalsに格納
	public boolean insertPhysicals(Physicals physicals) {
	    Connection conn = null;
	    boolean insertSuccess = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/B5", "yasuo", "yasuo");

			// Prepare the SQL statement
	        String sql = "INSERT INTO physicals (users_id, physicals_resistance, physicals_condition) VALUES (?, ?, ?)";
	        PreparedStatement pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, physicals.getUsers_id());
	        pstmt.setInt(2, physicals.getPhysicals_resistance());
	        pstmt.setInt(3, physicals.getPhysicals_condition());

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

	// physicalsを取得
	public List<Physicals> getAllPhysicals() {
	    Connection conn = null;
	    List<Physicals> physicalsList = new ArrayList<>();

	    try {
	        // JDBCドライバを読み込むs
	        Class.forName("org.h2.Driver");

	        // データベースに接続する
	        conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/B5", "yasuo", "yasuo");

	        String sql = "SELECT * FROM physicals WHERE users_id = ?";
	        PreparedStatement pstmt = conn.prepareStatement(sql);

	        ResultSet rs = pstmt.executeQuery();
	        while (rs.next()) {
	            int physicals_id = rs.getInt("physicals_id");
	            int users_id = rs.getInt("users_id");
	            int physicals_resistance = rs.getInt("physicals_resistance");
	            int physicals_condition = rs.getInt("physicals_condition");

	            // Physicalsオブジェクトを作成してリストに追加
	            Physicals physicals = new Physicals(physicals_id, users_id, physicals_resistance, physicals_condition, null, null);
	            physicalsList.add(physicals);
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

	    return physicalsList;
	}
}
