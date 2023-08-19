package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Appointment;


public class AppointmentListDao {

	
	String selectAppointment = "SELECT * FROM appointments WHERE seeker_username = ?";
	
	 public ArrayList<Appointment> getAppointmentList(String username) {
	        ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
	        try {
	        	Connection conn=DbConnection.getConnection();
	            PreparedStatement pstmt = conn.prepareStatement(selectAppointment);
	            pstmt.setString(1, username);
	            ResultSet rs = pstmt.executeQuery();
	            while (rs.next()) {
	               Appointment appointment= new Appointment();
	               int id=rs.getInt("id");
	               String consult_username=rs.getString("consult_username");
	               String seeker_username=rs.getString("seeker_username");
	               String date= rs.getString("date");
	               String time = rs.getString("time");
	               String consultFname=getFname(consult_username);
	               String seekerFname=getFname(seeker_username);
	               
	               appointment.setId(id);
	               appointment.setConsultUsername(consult_username);
	               appointment.setConsultFname(consultFname);
	               appointment.setSeekerUsername(seeker_username);
	               appointment.setSeekerFname(seekerFname);
	               appointment.setDate(date);
	               appointment.setTime(time);
	               
	               appointmentList.add(appointment);
	               
	            }
	            rs.close();
	            pstmt.close();
	            conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return appointmentList;
	    }
	 private String getFname(String username) {
		 String selectName = "SELECT fname FROM users WHERE username = ?";
		 String fName = null;
		 Connection conn=DbConnection.getConnection();
         
		try {
			PreparedStatement pstmt = conn.prepareStatement(selectName);
			pstmt.setString(1, username);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				fName=rs.getString("fname");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return fName;
	 }
}
