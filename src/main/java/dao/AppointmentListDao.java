package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Appointment;


public class AppointmentListDao {

	
	String selectSeekerAppointment = "SELECT * FROM appointments WHERE seeker_username = ? ORDER BY appointment_date ASC";
	String selectConsultAppointment = "SELECT * FROM appointments WHERE consult_username = ? ORDER BY appointment_date ASC";
	String allAppointments = "SELECT * FROM appointments ORDER BY appointment_date ASC";
	String FinishedAPpointmentList = "SELECT * FROM done_appointments WHERE MONTH(appointment_date) = MONTH(CURDATE())AND YEAR(appointment_date) = YEAR(CURDATE())ORDER BY appointment_date ASC, start_time ASC ";

	
	 public ArrayList<Appointment> getAppointmentList(String username) {
	        ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
	        try {
	        	Connection conn=DbConnection.getConnection();
	            PreparedStatement pstmt = conn.prepareStatement(selectSeekerAppointment);
	            pstmt.setString(1, username);
	            ResultSet rs = pstmt.executeQuery();
	            while (rs.next()) {
	               Appointment appointment= new Appointment();
	               int id=rs.getInt("id");
	               String consult_username=rs.getString("consult_username");
	               String seeker_username=rs.getString("seeker_username");
	               String date= rs.getString("appointment_date");
	               String time = rs.getString("appointment_time");
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
	 
	 public ArrayList<Appointment> getConsultAppointmentList(String username) {
	        ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
	        try {
	        	Connection conn=DbConnection.getConnection();
	            PreparedStatement pstmt = conn.prepareStatement(selectConsultAppointment);
	            pstmt.setString(1, username);
	            ResultSet rs = pstmt.executeQuery();
	            while (rs.next()) {
	               Appointment appointment= new Appointment();
	               int id=rs.getInt("id");
	               String consult_username=rs.getString("consult_username");
	               String seeker_username=rs.getString("seeker_username");
	               String date= rs.getString("appointment_date");
	               String time = rs.getString("appointment_time");
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
	 
	 public ArrayList<Appointment> getFinishedAppointmentList() {
	        ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
	        try {
	        	Connection conn=DbConnection.getConnection();
	            PreparedStatement pstmt = conn.prepareStatement(FinishedAPpointmentList);
	            ResultSet rs = pstmt.executeQuery();
	            while (rs.next()) {
	               Appointment appointment= new Appointment();
	               int id=rs.getInt("id");
	               String consult_username=rs.getString("consult_username");
	               String seeker_username=rs.getString("seeker_username");
	               String date= rs.getString("appointment_date");
	               String sTime = rs.getString("start_time");
	               String eTime=rs.getString("end_time");
	               String consultFname=getFname(consult_username);
	               String seekerFname=getFname(seeker_username);
	              
	               
	               appointment.setId(id);
	               appointment.setConsultUsername(consult_username); 
	               appointment.setSeekerUsername(seeker_username);
	               appointment.setDate(date);
	               appointment.setStartTime(sTime);
	               appointment.setEndTime(eTime);
	               appointment.setConsultFname(consultFname);
	               appointment.setSeekerFname(seekerFname);
	               
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
	 public ArrayList<Appointment> getAllAppointmentList() {
	        ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
	        try {
	        	Connection conn=DbConnection.getConnection();
	            PreparedStatement pstmt = conn.prepareStatement(allAppointments);
	            ResultSet rs = pstmt.executeQuery();
	            while (rs.next()) {
	               Appointment appointment= new Appointment();
	               int id=rs.getInt("id");
	               String consult_username=rs.getString("consult_username");
	               String seeker_username=rs.getString("seeker_username");
	               String date= rs.getString("appointment_date");
	               String time = rs.getString("appointment_time");
	               
	               String consultFname=getFname(consult_username);
	               String seekerFname=getFname(seeker_username);
	              
	               
	               appointment.setId(id);
	               appointment.setConsultUsername(consult_username); 
	               appointment.setSeekerUsername(seeker_username);
	               appointment.setDate(date);
	               appointment.setTime(time);
	              
	               appointment.setConsultFname(consultFname);
	               appointment.setSeekerFname(seekerFname);
	               
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
	 
}
