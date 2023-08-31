package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class UserDao {
	String usernameCheck="SELECT * FROM users WHERE username=?";
	String insertSql = "INSERT INTO users "
			+ "( fname, lname, username, password, email, dob, gender, contact, type)"
			+ "VALUES"
			+ "(?, ?, ?, ?, ?, ?, ?, ?, ?)" ;
	
	//Check Username exits
	public boolean usernameCheck(String username) {
		boolean usernameExits=false;
		
		Connection conn=DbConnection.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement(usernameCheck);
			ps.setString(1, username);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				usernameExits=false;
			}
			else {
				usernameExits=true;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return usernameExits;
	}
	
   //Insert New User
	public int registration(User user) throws ClassNotFoundException {
	
		int result = 0;
	
		try {
			
			Connection conn = DbConnection.getConnection();
			 
			PreparedStatement ps = conn.prepareStatement(insertSql);
			ps.setString(1,user.getfName());
			ps.setString(2,user.getlName());
			ps.setString(3,user.getUsername());
			ps.setString(4,user.getPassword());
			ps.setString(5,user.getEmail());
			ps.setString(6,user.getDob());
			ps.setString(7,user.getGender());
			ps.setString(8,user.getContact());
			ps.setString(9,user.getType());
			
			result = ps.executeUpdate();
			ps.close();
			conn.close();
			
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		
		
		return result;
	}
	
}
