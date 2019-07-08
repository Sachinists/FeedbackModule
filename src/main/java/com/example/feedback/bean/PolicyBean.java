package com.example.feedback.bean;

public class PolicyBean {

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
	
}
