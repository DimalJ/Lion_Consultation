package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AppointmentsEditDao {

	String sql = "INSERT INTO done_appointments (seeker_username, consult_username, appointment_date, start_time, end_time) " +
            "VALUES (?, ?, ?, ?, ?)";
	String delSql="DELETE FROM appointments WHERE id=?";
	
	public boolean addAppointment(String seekerusername,String consultUsername, String appointmentDate,String startTime,String endTime) {
		Connection conn=DbConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,seekerusername);
			ps.setString(2,consultUsername);
			ps.setString(3,appointmentDate);
			ps.setString(4,startTime);
			ps.setString(5,endTime);
			
			int rowAffected=ps.executeUpdate();
			conn.close();
			
			return rowAffected>0;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	public boolean removeAppointment(int Id) {
		Connection conn = DbConnection.getConnection();
		
		try {
			PreparedStatement ps=conn.prepareStatement(delSql);
			ps.setInt(1, Id);
			int rowAffected = ps.executeUpdate();
			
			conn.close();
			return rowAffected>0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
}
