package com.example.feedback.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.example.feedback.bean.PolicyTakenBean;
import com.example.feedback.bean.UserBean;

@Entity
@Table(name = "userDetails")
@GenericGenerator(name = "pkgen", strategy = "increment")
public class UserEntity {

	@Id
	@GeneratedValue(generator = "pkgen")
	private int userID;
	private String username;
	private String address;
	private LocalDate dateOfBirth;
	private long phonenumber;
	
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "userPolicyMapping", 
        joinColumns = { @JoinColumn(name = "userID") }, 
        inverseJoinColumns = { @JoinColumn(name = "policyTakenID") }
    )
	private List<PolicyTakenEntity> policiesTaken;
	
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
	public List<PolicyTakenEntity> getPoliciesTaken() {
		return policiesTaken;
	}
	public void setPoliciesTaken(List<PolicyTakenEntity> policiesTaken) {
		this.policiesTaken = policiesTaken;
	}
	
	public UserBean toBean() {
		UserBean userBean = new UserBean();
		userBean.setAddress(this.getAddress());
		userBean.setDateOfBirth(this.getDateOfBirth());
		userBean.setPhonenumber(this.getPhonenumber());
		userBean.setUserID(this.getUserID());
		userBean.setUsername(this.getUsername());
		if(this.getPoliciesTaken().size() > 0) {
			List<PolicyTakenBean> list = new ArrayList<>();
			this.getPoliciesTaken().forEach(p -> {
				list.add(p.toBean());
			});
			userBean.setPoliciesTaken(list);
		}
		return userBean;
	}
	
}
