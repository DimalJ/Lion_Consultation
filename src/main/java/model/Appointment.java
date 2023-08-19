package model;

public class Appointment {
	
private int id;
private String seekerUsername;
private String consultUsername;
private String Date;
private String time;
private String seekerFname;
private String consultFname;


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
