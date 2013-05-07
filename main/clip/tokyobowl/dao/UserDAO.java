package clip.tokyobowl.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import clip.tokyobowl.model.User;

public class UserDAO {
	public static void updateUser(User user) throws SQLException {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DriverManager.getConnection("jdbc:myDriver:rtr",
					"root", "1234");
			pstmt = con.prepareStatement("UPDATE user SET password = ? "
					+ "email = ?" + "address = ?" + "phone = ?"
					+ "WHERE userId = ?");
			pstmt.setString(1, user.getPassword());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getAddress());
			pstmt.setString(4, user.getPhone());
			pstmt.setString(5, user.getUserId());
			pstmt.executeUpdate();
		} finally {
			if (pstmt != null)
				pstmt.close();
		}
	}

	public static void AddUser(User user) throws SQLException {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DriverManager.getConnection("jdbc:myDriver:rtr",
					"root", "1234");
			pstmt = con
					.prepareStatement("INSERT INTO user (userId, password, lastName, firstName, isAdmin, email, address, phone) VALUES ("
							+ "userId = ?"
							+ "password = ?"
							+ "lastName = ?"
							+ "firstName = ?"
							+ "isAdmin = 0"
							+ "email = ?"
							+ "address = ?" + "phone = ?");
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getLastName());
			pstmt.setString(4, user.getFirstName());
			pstmt.setString(5, user.getUserId());
			pstmt.execute();
		} finally {
			if (pstmt != null)
				pstmt.close();
		}
	}

	public static User getUserInformationById(String userId)
			throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:myDriver:rtr",
				"root", "1234");
		PreparedStatement pstmt = null;
		pstmt = con
				.prepareStatement("Select lastName, firstName, isAdmin, email, address, phone where userId=?");

		ResultSet rs = pstmt
				.executeQuery("Select lastName, firstName, isAdmin, email, address, phone where userId=?");
		User user = new User();
		while (rs.next()) {
			user.setLastName(rs.getString("lastName"));
			user.setLastName(rs.getString("firstName"));
			user.setAdmin(rs.getBoolean("isAdmin"));
			user.setLastName(rs.getString("email"));
			user.setLastName(rs.getString("address"));
			user.setLastName(rs.getString("phone"));
		}
		return user;
	}
	
	public static User getUserInformationByIdAndPassword(String userId, String password)
			throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:myDriver:rtr",
				"root", "1234");
		PreparedStatement pstmt = null;
		pstmt = con
				.prepareStatement("Select lastName, firstName, isAdmin, email, address, phone where userId=?");

		ResultSet rs = pstmt
				.executeQuery("Select lastName, firstName, isAdmin, email, address, phone where userId=? and password=?");
		User user = new User();
		while (rs.next()) {
			user.setLastName(rs.getString("lastName"));
			user.setLastName(rs.getString("firstName"));
			user.setAdmin(rs.getBoolean("isAdmin"));
			user.setLastName(rs.getString("email"));
			user.setLastName(rs.getString("address"));
			user.setLastName(rs.getString("phone"));
		}
		return user;
	}
}
