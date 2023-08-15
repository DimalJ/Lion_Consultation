package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class EditUserDao {

	String selectUsers = "SELECT * FROM users WHERE username = ?";
	String updateSQL= "UPDATE users SET fname=?, lname=?, password=?, email=?, dob=?, gender=?, contact=?, type=? WHERE username=?";
	String deleteUsers = "DELETE from users WHERE username=?";
	private User user;
	
	
	public User getUser(String username) throws SQLException {
		
		
		try {
			Connection conn=DbConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(selectUsers);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
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
			conn.close();
			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return user;
	}
	
	public boolean updateUser(String fName,String lName,String password, String email, String dob,String gender, String contact,String type, String username ) {
		
		try {
			Connection conn=DbConnection.getConnection();
			PreparedStatement ps= conn.prepareStatement(updateSQL);
			ps.setString(1, fName);
			ps.setString(2, lName);
			ps.setString(3, password);
			ps.setString(4, email);
			ps.setString(5, dob);
			ps.setString(6, gender);
			ps.setString(7, contact);
			ps.setString(8, type);
			ps.setString(9, username);
			
			int rowaffected=ps.executeUpdate();
			conn.close();
			
			return rowaffected>0;
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	public boolean deleteUser(String username) {
		
		try {
			Connection conn=DbConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(deleteUsers);
			ps.setString(1, username);
			
			int rowaffected=ps.executeUpdate();
			conn.close();
			
			return rowaffected>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
