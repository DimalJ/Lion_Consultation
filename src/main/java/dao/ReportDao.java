package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReportDao {
	
	String newUserSQL = "SELECT COUNT(*) AS total_joiners\r\n"
			+ "FROM users\r\n"
			+ "WHERE MONTH(joinedDate) = MONTH(CURDATE())\r\n"
			+ "  AND YEAR(joinedDate) = YEAR(CURDATE())\r\n"
			+ "  AND type = 'jobSeeker'";
	String totalUserSQL = "SELECT COUNT(*) AS total_joiners\r\n"
			+ "FROM users\r\n"
			+ "WHERE type = 'jobSeeker'";
	String totalconsultSQL = "SELECT COUNT(*) AS total_joiners\r\n"
			+ "FROM users\r\n"
			+ "WHERE type = 'consultant'";
	
	String monthlyAppointmentsSQL = "SELECT COUNT(*) AS total_appointments FROM done_appointments WHERE MONTH(appointment_date)= MONTH(CURDATE()) AND YEAR(appointment_date) = YEAR(CURDATE())";
	String totalAppointmentsSQL = "SELECT COUNT(*) AS total_appointments FROM done_appointments";
	String pendingTotalAppointmentsSQL = "SELECT COUNT(*) AS total_appointments FROM appointments";
			
	
	public int getMonthlyappointment() {
		Connection conn= DbConnection.getConnection();
		int count=0;
		try {
			PreparedStatement ps = conn.prepareStatement(monthlyAppointmentsSQL);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				count = rs.getInt("total_appointments");
				conn.close();
				return count;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	public int getPendingappointment() {
		Connection conn= DbConnection.getConnection();
		int count=0;
		try {
			PreparedStatement ps = conn.prepareStatement(pendingTotalAppointmentsSQL);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				count = rs.getInt("total_appointments");
				conn.close();
				return count;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	public int getTotalappointment() {
		Connection conn= DbConnection.getConnection();
		int count=0;
		try {
			PreparedStatement ps = conn.prepareStatement(totalAppointmentsSQL);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				count = rs.getInt("total_appointments");
				conn.close();
				return count;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	public int getTotalConsultUser() {
		Connection conn= DbConnection.getConnection();
		int count=0;
		try {
			PreparedStatement ps = conn.prepareStatement(totalconsultSQL);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				count = rs.getInt("total_joiners");
				conn.close();
				return count;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	public int getNewUser() {
		Connection conn= DbConnection.getConnection();
		int count=0;
		try {
			PreparedStatement ps = conn.prepareStatement(newUserSQL);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				count = rs.getInt("total_joiners");
				conn.close();
				return count;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	public int getTotalUser() {
		Connection conn= DbConnection.getConnection();
		int count=0;
		try {
			PreparedStatement ps = conn.prepareStatement(totalUserSQL);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				count = rs.getInt("total_joiners");
				conn.close();
				return count;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

}
