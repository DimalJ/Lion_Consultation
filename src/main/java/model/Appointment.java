package model;

public class Appointment {
	
private int id;
private String seekerUsername;
private String consultUsername;
private String Date;
private String time;
private String seekerFname;
private String consultFname;
private String startTime;
private String endTime;


public Appointment(int id2, String seekerUsername2, String consultUsername2, String seekerName, String consultName,
		String date2, String time2) {
	this.id = id2;
	this.seekerUsername=seekerUsername2;
	this.consultUsername=consultUsername2;
	this.consultFname=consultName;
	this.seekerFname=seekerName;
	this.Date=date2;
	this.time=time2;
			
}
public Appointment() {
	// TODO Auto-generated constructor stub
}
public String getStartTime() {
	return startTime;
}
public void setStartTime(String startTime) {
	this.startTime = startTime;
}
public String getEndTime() {
	return endTime;
}
public void setEndTime(String endTime) {
	this.endTime = endTime;
}
public String getSeekerFname() {
	return seekerFname;
}
public void setSeekerFname(String seekerFname) {
	this.seekerFname = seekerFname;
}
public String getConsultFname() {
	return consultFname;
}
public void setConsultFname(String consultFname) {
	this.consultFname = consultFname;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getSeekerUsername() {
	return seekerUsername;
}
public void setSeekerUsername(String seekerUsername) {
	this.seekerUsername = seekerUsername;
}
public String getConsultUsername() {
	return consultUsername;
}
public void setConsultUsername(String consultUsername) {
	this.consultUsername = consultUsername;
}
public String getDate() {
	return Date;
}
public void setDate(String date) {
	Date = date;
}
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}


}
