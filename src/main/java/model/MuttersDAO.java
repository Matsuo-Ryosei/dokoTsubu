package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MuttersDAO {
	// データベースに接続
	// Databseへの接続情報
	final String DATABASE = "dokotsubu";
	final String USER = "postgres";
	final String PASSWORD = "root";
	final String URL = "jdbc:postgresql://localhost:5432/" + DATABASE;

	public List<Mutter> findAll() {
		List<Mutter> muttersList = new ArrayList<>();
		// JDBCのドライバーのロード
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("【失敗】 JDBCのドライバーが読み込めません");
			e.printStackTrace();
		}
		// データベースに接続
		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
			// SELECT文を準備
			String sql = " SELECT ID,NAME,TEXT FROM MUTTERS ORDER BY ID DESC; ";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SELECT文を実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();

			// 結果表に格納された内容をEmployeeインスタンスに設定し、ArrayListインスタンスに追加
			while (rs.next()) {
				int id = rs.getInt("ID");
				String userName = rs.getString("NAME");
				String text = rs.getString("TEXT");
				Mutter mutter = new Mutter(id, userName, text);
				muttersList.add(mutter);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return muttersList;
	}
	
	public boolean create(Mutter mutter) {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("【失敗】 JDBCのドライバーが読み込めません");
			e.printStackTrace();
		}
		// データベースに接続
		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
			String sql = " INSERT INTO MUTTERS(NAME, TEXT) VALUES(?, ?); ";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, mutter.getUserName());
			pStmt.setString(2, mutter.getText());
			
			int result = pStmt.executeUpdate();
			if (result != 1) {
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
