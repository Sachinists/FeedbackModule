package com.example.feedback.bean;

import java.time.LocalDate;

public class PolicyTakenBean {

	private int policyTakenID;
	private PolicyBean policyBean;
	private long policyAmount;
	private int premiumType;
	private int premiumAmount;
	private LocalDate premiumDate;
	private LocalDate startDate;
	private LocalDate endDate;
	private int tenure;
	
	public int getPolicyTakenID() {
		return policyTakenID;
	}
	public void setPolicyTakenID(int policyTakenID) {
		this.policyTakenID = policyTakenID;
	}
	public PolicyBean getPolicyBean() {
		return policyBean;
	}
	public void setPolicyBean(PolicyBean policyBean) {
		this.policyBean = policyBean;
	}
	public long getPolicyAmount() {
		return policyAmount;
	}
	public void setPolicyAmount(long policyAmount) {
		this.policyAmount = policyAmount;
	}
	public int getPremiumType() {
		return premiumType;
	}
	public void setPremiumType(int premiumType) {
		this.premiumType = premiumType;
	}
	public int getPremiumAmount() {
		return premiumAmount;
	}
	public void setPremiumAmount(int premiumAmount) {
		this.premiumAmount = premiumAmount;
	}
	public LocalDate getPremiumDate() {
		return premiumDate;
	}
	public void setPremiumDate(LocalDate premiumDate) {
		this.premiumDate = premiumDate;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public int getTenure() {
		return tenure;
	}
	public void setTenure(int tenure) {
		this.tenure = tenure;
	}
}
