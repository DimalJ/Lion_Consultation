package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class EditUserDao {

	String selectUsers = "SELECT * FROM users WHERE username = ?";
	private User user;
	
	
	public User getUser(String username) {
		
		Connection conn=DbConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(selectUsers);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				user = new User();
				user.setfName(rs.getString("fName"));
				user.setlName(rs.getString("lName"));
				user.setUsername(username);
				user.setPassword(rs.getString("password"));
				user.setDob(rs.getString("dob"));
				user.setGender(rs.getString("gender"));
				user.setEmail(rs.getString("email"));
				user.setType(rs.getString("type"));
				user.setContact(rs.getString("contact"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
}
