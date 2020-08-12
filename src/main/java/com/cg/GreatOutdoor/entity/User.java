package com.cg.GreatOutdoor.entity;

//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToMany;
import javax.persistence.Table;
//import org.hibernate.validator.constraints.Range;


@Entity
@Table(name = "userTable")
public class User {

	@Id
	@Column(name="user_id")
	private long userId;
	
	@Column(name="USERNAME",length=20)
	private String userName;

	@Column(name="PASSWORD",length = 20)
	private String password;

	@Column(name="ROLE",length = 20)
	private String role;

	@Column(name="PHONENUMBER",length = 16)
	private String phoneNumber;

	@Column(name="EMAIL",length = 50)
	private String email;
	
	

	public User( String userName, String password, String role,
			String phoneNumber, String email) {
		super();
		
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public User(String userName, String password, String phoneNumber, String email) {
		super();
		this.userName = userName;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
	
}