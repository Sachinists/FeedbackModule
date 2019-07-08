package com.example.feedback.bean;

import java.time.LocalDate;

public class TransactionBean {

	private int transactionID;
//	private PolicyTakenBean policyTakenBean;
//	private UserBean userBean;
	private int policyTakenID;
	private int userID;
	private LocalDate transactionDate;
	private int transactionAmount;
	
	public int getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}
	public int getPolicyTakenID() {
		return policyTakenID;
	}
	public void setPolicyTakenID(int policyTakenID) {
		this.policyTakenID = policyTakenID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public LocalDate getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}
	public int getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(int transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	
}
