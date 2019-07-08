package com.example.feedback.bean;

import java.time.LocalDate;
import java.util.List;

import com.example.feedback.entity.PolicyTakenEntity;

public class UserBean {

	private int userID;
	private String username;
	private String address;
	private LocalDate dateOfBirth;
	private long phonenumber;
	private List<PolicyTakenBean> policiesTaken;
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public long getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}
	public List<PolicyTakenBean> getPoliciesTaken() {
		return policiesTaken;
	}
	public void setPoliciesTaken(List<PolicyTakenBean> policiesTaken) {
		this.policiesTaken = policiesTaken;
	}
	
}
