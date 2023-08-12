package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class LoginDao {

	 public boolean authenticate(String username, String password) {
	        boolean authenticated = false;
	        try {
	           
	            Connection conn = DbConnection.getConnection();
	            String sql = "SELECT password FROM users WHERE username = ?";
	            PreparedStatement pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, username);
	            ResultSet rs = pstmt.executeQuery();
	            if (rs.next()) {
	                String storedPassword = rs.getString("password");
	                if (password.equals(storedPassword)) {
	                    authenticated = true;
	                }
	            }
	            rs.close();
	            pstmt.close();
	            conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return authenticated;
	    } 

	    public String getUserType(String username) {
	        String userType = null;
	        try {           
	            Connection conn = DbConnection.getConnection();
	            String sql = "SELECT type FROM users WHERE username = ?";
	            PreparedStatement pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, username);
	            ResultSet rs = pstmt.executeQuery();
	            if (rs.next()) {
	                userType = rs.getString("type");
	            }
	            rs.close();
	            pstmt.close();
	            conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return userType;
	    }
	
}
