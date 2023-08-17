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

	        Connection conn = DbConnection.getConnection();
	        try (
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
	 
	 public boolean addAppointment(String seekerUsername, String consultUsername,  String date, String time ) {
		 String sql= "INSERT INTO appointments "
					+ "( seeker_username, consult_username, appointment_date, appointment_time)"
					+ "VALUES"
					+ "(?, ?, ?, ?)" ;
		 Connection conn = DbConnection.getConnection();
		 try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,seekerUsername);
			ps.setString(2, consultUsername);
			ps.setString(3, date);
			ps.setString(4, time);
			
			int rowAffected= ps.executeUpdate();
			return rowAffected>0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return false;
		 
	 }
}
