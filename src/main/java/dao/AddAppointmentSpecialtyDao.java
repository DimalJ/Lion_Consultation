package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class AddAppointmentSpecialtyDao {
	
	String sqlQuery = "SELECT username FROM specialized WHERE industry = ? AND region = ?";
	

	 public List<User> getAvailableConsultants(String industry, String region) {
	        List<User> availableConsultants = new ArrayList<>();
	      
	        Connection conn = DbConnection.getConnection();
	        try (
	             PreparedStatement preparedStatement = conn.prepareStatement(sqlQuery)) {
		            preparedStatement.setString(1, industry);
		            preparedStatement.setString(2, region);
		            

	            try (ResultSet rs = preparedStatement.executeQuery()) {
	                while (rs.next()) {
	                	String searchUser = "SELECT * FROM users WHERE username=?";
	                    String username= rs.getString("username");
	                    PreparedStatement ps= conn.prepareStatement(searchUser);
	                    ps.setString(1, username);
	                    
	                    ResultSet resultSet = ps.executeQuery();
	                    while (resultSet.next()){
	                    	String name=resultSet.getString("fname");
	                    	String consultUsername = resultSet.getString("username");
	                    	String gender = resultSet.getString("gender");
	                    	availableConsultants.add(new User(name,consultUsername,gender));
	                    }
	                   resultSet.close();
	                }
	                rs.close();
	                conn.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return availableConsultants;
	    }
}
