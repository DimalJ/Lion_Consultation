package model;


public class User {

	
	private String fName;
	private String lName;
	private String username;
	private String email;
	private String password;
	private String dob;
	private String gender;
	private String contact;
	private String type;
	private String joinedDate;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(String fName, String lName, String username, String email, String contact) {
		// TODO Auto-generated constructor stub
		this.fName=fName;
		this.lName=lName;
		this.username=username;
		this.email=email;
		this.contact=contact;
		
	}
	public User(String fName, String username, String gender) {
		this.fName=fName;
		this.username=username;
		this.gender=gender;
	}
	
	public String getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(String joinedDate) {
		this.joinedDate = joinedDate;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	
	
}
