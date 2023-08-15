package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class AddAppointmentDao {

	 public List<User> getAvailableConsultants(String appointmentDate, String appointmentTime) {
	        List<User> availableConsultants = new ArrayList<>();
	        String sql = "SELECT * FROM consultant_availability WHERE available_date = ? AND start_time <= ? AND finish_time >= ?";

	        try (Connection conn = DbConnection.getConnection();
	             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
		            preparedStatement.setString(1, appointmentDate);
		            preparedStatement.setString(2, appointmentTime);
		            preparedStatement.setString(3, appointmentTime);

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
