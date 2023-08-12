package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.User;

public class AdminViewUserDao {

	String updateSQL= "UPDATE users SET fname=?, lname=?, password=?, email=?, dob=?, gender=?, contact=?, type=? WHERE username=?";
	String selectUsers = "SELECT fname, lname, username, email, contact FROM users WHERE type = ?";
	String deleteUsers = "DELETE from users WHERE username=?";
			
	
	 public ArrayList<User> getUsersByType(String userType) {
	        ArrayList<User> usersList = new ArrayList<User>();
	        try {
	        	Connection conn=DbConnection.getConnection();
	            PreparedStatement pstmt = conn.prepareStatement(selectUsers);
	            pstmt.setString(1, userType);
	            ResultSet rs = pstmt.executeQuery();
	            while (rs.next()) {
	                String firstName = rs.getString("fname");
	                String lastName = rs.getString("lname");
	                String username = rs.getString("username");
	                String email = rs.getString("email");
	                String contact = rs.getString("contact");
	                usersList.add(new User(firstName, lastName, username, email, contact));
	            }
	            rs.close();
	            pstmt.close();
	            conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return usersList;
	    }
}
