package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.entity.User;

public class InputDao {

	//SQL接続情報
	final String URL = "jdbc:mysql://localhost:3306/sample";
	final String ROOT_USER = "root";
	final String PASS = "Administrator0102";

	/**
	 * ユーザー情報登録
	 *
	 * @param user ユーザー
	 * @return count
	 */
	public int userInsert(User user) {
		int count = 0;
		try {
			Connection conn = null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, ROOT_USER, PASS);
				PreparedStatement preStatement = conn.prepareStatement("insert into user values(?, ?, ?, ?, ?, ?, ?,?);");

			preStatement.setInt(1, user.getUserid());
			preStatement.setString(2, user.getName());
			preStatement.setString(3, user.getTel());
			preStatement.setDate(4, user.getBirthday());
			preStatement.setString(5, user.getGender());
			preStatement.setString(6, user.getMail());
			preStatement.setDate(7, user.getInsdate());
			preStatement.setDate(8, user.getUpddate());
			count = preStatement.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			System.out.println("ユーザーを追加しました。");
		}
		return count;
	}

	/**
	 * ユーザー.ユーザーID取得
	 *
	 * @param user ユーザー
	 * @return count
	 */
	public List<Integer> selectUserid() {
		List<Integer> userids = new ArrayList<>();
		try {
			Connection conn = null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, ROOT_USER, PASS);
				PreparedStatement preStatement = conn
						.prepareStatement("select userid from user;");

			try (ResultSet rs = preStatement.executeQuery()) {
				while (rs.next()) {
					userids.add(rs.getInt("userid"));
				}
			}
		} catch (SQLException| ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			System.out.println("処理が完了しました");
		}
		return userids;
	}
}
