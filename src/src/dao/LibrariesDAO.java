package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import model.Libraries;
import model.PostLibraries;

public class LibrariesDAO {
	// Librariesに格納
	public boolean insertLibraries(PostLibraries post_lib) {
	    Connection conn = null;
	    boolean insertSuccess = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/B5", "yasuo", "yasuo");

			// Prepare the SQL statement
	        String sql = "INSERT INTO libraries (libraries_description, libraries_genre, libraries_kind, libraries_alcon, libraries_from, libraries_remarks) VALUES (?, ?, ?, ?, ?, ?)";
	        PreparedStatement pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, post_lib.getPost_description());
	        pstmt.setString(2, post_lib.getPost_genre());
	        pstmt.setString(3, post_lib.getPost_kind());
	        double post_alcon = Double.parseDouble(post_lib.getPost_alcon());
	        pstmt.setDouble(4, post_alcon);
	        pstmt.setString(5, post_lib.getPost_from());
	        pstmt.setString(6, post_lib.getPost_remarks());


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

	 // 全てのLibrariesを取得
    public List<Libraries> getAllLibraries() {
        Connection conn = null;
        List<Libraries> librariesList = new ArrayList<>();

        try {
            // JDBCドライバを読み込む
            Class.forName("org.h2.Driver");

            // データベースに接続する
            conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/B5", "yasuo", "yasuo");

            String sql = "SELECT * FROM libraries ORDER BY libraries_id";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            // SQL文を実行し、結果を取得する
            ResultSet rs = pstmt.executeQuery();
            // 結果をコレクションにコピーする
            while (rs.next()) {
                Libraries libraries = new Libraries(
                        rs.getInt("libraries_id"),
                        rs.getString("libraries_description"),
                        rs.getString("libraries_genre"),
                        rs.getString("libraries_kind"),
                        rs.getDouble("libraries_alcon"),
                        rs.getString("libraries_from"),
                        rs.getString("libraries_remarks"),
                        rs.getBoolean("libraries_public"),
                        rs.getTimestamp("created_at"),
                        rs.getTimestamp("updated_at")
                );
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

	// librariesキーワード検索
		public List<Libraries> searchLibraries(String keyword) {
		    Connection conn = null;
		    List<Libraries> searchList = new ArrayList<>();

		    try {
		        // JDBCドライバを読み込むs
		        Class.forName("org.h2.Driver");

		        // データベースに接続する
		        conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/B5", "yasuo", "yasuo");

		        String sql = "SELECT * FROM libraries WHERE libraries_description LIKE ? OR libraries_genre LIKE ? OR libraries_kind LIKE ? OR libraries_from LIKE ? OR libraries_remarks LIKE ?";
		        PreparedStatement pstmt = conn.prepareStatement(sql);
	            String wildcardKeyword = "%" + keyword + "%";
	            pstmt.setString(1, wildcardKeyword);
	            pstmt.setString(2, wildcardKeyword);
	            pstmt.setString(3, wildcardKeyword);
	            pstmt.setString(4, wildcardKeyword);
	            pstmt.setString(5, wildcardKeyword);
		        ResultSet rs = pstmt.executeQuery();
		        while (rs.next()) {
		            int libraries_id = rs.getInt("libraries_id");
		            String libraries_description = rs.getString("libraries_description");
		            String libraries_genre = rs.getString("libraries_genre");
		            String libraries_kind = rs.getString("libraries_kind");
		            Double libraries_alcon = rs.getDouble("libraries_alcon");
		            String libraries_from = rs.getString("libraries_from");
		            String libraries_remarks = rs.getString("libraries_remarks");
		            Boolean libraries_public = rs.getBoolean("libraries_public");
		            Timestamp created_at = rs.getTimestamp("updated_at");
		            Timestamp updated_at = rs.getTimestamp("created_at");


		            // librariesオブジェクトを作成してリストに追加
		            Libraries libraries = new Libraries(libraries_id, libraries_description, libraries_genre, libraries_kind, libraries_alcon, libraries_from, libraries_remarks, libraries_public, created_at, updated_at);
		            searchList.add(libraries);
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

		    return searchList;
		}


		// libraries絞り込み検索
		public List<Libraries> narrowLibraries(String genre, String kind, String from) {
		    Connection conn = null;
		    List<Libraries> narrowList = new ArrayList<>();
		    ResultSet rs = null;
		    PreparedStatement pstmt = null;
		    try {
		        // JDBCドライバを読み込む
		        Class.forName("org.h2.Driver");

		        // データベースに接続する
		        conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/B5", "yasuo", "yasuo");

		        StringBuilder sqlBuilder = new StringBuilder("SELECT * FROM libraries WHERE ");
		        List<String> conditions = new ArrayList<>();
		        List<String> values = new ArrayList<>();


		        if (!genre.isEmpty()) {
		            conditions.add("libraries_genre LIKE ?");
		            values.add("%" + genre + "%");
		        }
		        if (!kind.isEmpty()) {
		            conditions.add("libraries_kind LIKE ?");
		            values.add("%" + kind + "%");
		        }
		        if (!from.isEmpty()) {
		            conditions.add("libraries_from LIKE ?");
		            values.add("%" + from + "%");
		        }

		        if (!conditions.isEmpty()) {
		            String sql = sqlBuilder.append(String.join(" AND ", conditions)).toString();
		            pstmt = conn.prepareStatement(sql);

		            for (int i = 0; i < values.size(); i++) {
		                pstmt.setString(i + 1, values.get(i));
		            }

		            rs = pstmt.executeQuery();

		            while (rs.next()) {
		                int libraries_id = rs.getInt("libraries_id");
		                String libraries_description = rs.getString("libraries_description");
		                String libraries_genre = rs.getString("libraries_genre");
		                String libraries_kind = rs.getString("libraries_kind");
		                Double libraries_alcon = rs.getDouble("libraries_alcon");
		                String libraries_from = rs.getString("libraries_from");
		                String libraries_remarks = rs.getString("libraries_remarks");
		                Boolean libraries_public = rs.getBoolean("libraries_public");
		                Timestamp created_at = rs.getTimestamp("created_at");
		                Timestamp updated_at = rs.getTimestamp("updated_at");

		                Libraries libraries = new Libraries(libraries_id, libraries_description, libraries_genre, libraries_kind, libraries_alcon, libraries_from, libraries_remarks, libraries_public, created_at, updated_at);
		                narrowList.add(libraries);
		            }
		        }
		    } catch (SQLException | ClassNotFoundException e) {
		        e.printStackTrace();
		    } finally {
		        // リソースを解放する
		        if (rs != null) {
		            try {
		                rs.close();
		            } catch (SQLException e) {
		                e.printStackTrace();
		            }
		        }
		        if (pstmt != null) {
		            try {
		                pstmt.close();
		            } catch (SQLException e) {
		                e.printStackTrace();
		            }
		        }
		        if (conn != null) {
		            try {
		                conn.close();
		            } catch (SQLException e) {
		                e.printStackTrace();
		            }
		        }
		    }

		    return narrowList;
		}
		// Librariesのlibraries_descriptionを取得
	    public List<Libraries> getDescription() {
	        Connection conn = null;
	        List<Libraries> descriptionList = new ArrayList<>();

	        try {
	            // JDBCドライバを読み込む
	            Class.forName("org.h2.Driver");

	            // データベースに接続する
	            conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/B5", "yasuo", "yasuo");

	            String sql = "SELECT libraries_description FROM libraries";
	            PreparedStatement pstmt = conn.prepareStatement(sql);
	            // SQL文を実行し、結果を取得する
	            ResultSet rs = pstmt.executeQuery();
	            // 結果をコレクションにコピーする
	            while (rs.next()) {
	                String description = rs.getString("libraries_description");
	                Libraries libraries = new Libraries();
	                libraries.setLibraries_description(description);
	                descriptionList.add(libraries);
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

	        return descriptionList;
	    }

	 // Librariesのlibraries_genreを取得
	    public List<Libraries> getGenre() {
	        Connection conn = null;
	        List<Libraries> genreList = new ArrayList<>();

	        try {
	            // JDBCドライバを読み込む
	            Class.forName("org.h2.Driver");

	            // データベースに接続する
	            conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/B5", "yasuo", "yasuo");

	            String sql = "SELECT libraries_genre FROM libraries";
	            PreparedStatement pstmt = conn.prepareStatement(sql);
	            // SQL文を実行し、結果を取得する
	            ResultSet rs = pstmt.executeQuery();
	            // 結果をコレクションにコピーする
	            while (rs.next()) {
	                String genre = rs.getString("libraries_genre");
	                Libraries libraries = new Libraries();
	                libraries.setLibraries_genre(genre);
	                genreList.add(libraries);
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

	        return genreList;
	    }

	 // Librariesのlibraries_kindを取得
	    public List<Libraries> getKind() {
	        Connection conn = null;
	        List<Libraries> kindList = new ArrayList<>();

	        try {
	            // JDBCドライバを読み込む
	            Class.forName("org.h2.Driver");

	            // データベースに接続する
	            conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6/data/B5", "yasuo", "yasuo");

	            String sql = "SELECT libraries_kind FROM libraries";
	            PreparedStatement pstmt = conn.prepareStatement(sql);
	            // SQL文を実行し、結果を取得する
	            ResultSet rs = pstmt.executeQuery();
	            // 結果をコレクションにコピーする
	            while (rs.next()) {
	                String kind = rs.getString("libraries_genre");
	                Libraries libraries = new Libraries();
	                libraries.setLibraries_kind(kind);
	                kindList.add(libraries);
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

	        return kindList;
	    }

}
