package com.example.feedback.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.example.feedback.bean.PolicyBean;

@Entity
@Table(name = "policy")
@GenericGenerator(name = "pkgen", strategy = "increment")
public class PolicyEntity {

	@Id
	@GeneratedValue(generator = "pkgen")
	private int policyID;
	private String pName;
	private String pDescription;
	
	
	@Override
	public String toString() {
		return this.policyID + " : " + this.pDescription + " : " + this.pName;
	}
	public int getPolicyID() {
		return policyID;
	}
	public void setPolicyID(int policyID) {
		this.policyID = policyID;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpDescription() {
		return pDescription;
	}
	public void setpDescription(String pDescription) {
		this.pDescription = pDescription;
	}
	
	public PolicyBean toBean() {
		PolicyBean policyBean = new PolicyBean();
		policyBean.setpDescription(this.getpDescription());
		policyBean.setpName(this.getpName());
		policyBean.setPolicyID(this.getPolicyID());
		return policyBean;
	}
	
	public void set(PolicyBean policyBean) {
		this.setpName(policyBean.getpName());
		this.setpDescription(policyBean.getpDescription());
	}
}
