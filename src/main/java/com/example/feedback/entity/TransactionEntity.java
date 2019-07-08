package com.example.feedback.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.example.feedback.bean.TransactionBean;

@Entity
@Table(name = "transactionDetails")
@GenericGenerator(name = "pkgen", strategy = "increment")
public class TransactionEntity {
	@Id
	@GeneratedValue(generator = "pkgen")
	private int transactionID;

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "policyTakenID")
//	private PolicyTakenEntity policyTakenEntity;
	private int policyTakenID;
	private int userID;
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "userID")
//	private UserEntity userEntity;

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

	public TransactionBean toBean() {
		TransactionBean transactionBean = new TransactionBean();
		transactionBean.setTransactionAmount(this.getTransactionAmount());
		transactionBean.setTransactionDate(this.getTransactionDate());
		transactionBean.setTransactionID(this.getTransactionID());
		transactionBean.setPolicyTakenID(this.getPolicyTakenID());
		transactionBean.setUserID(this.getUserID());
		return transactionBean;
	}
	
	public void set(TransactionBean transactionBean) {
		this.setPolicyTakenID(transactionBean.getPolicyTakenID());
		this.setTransactionAmount(transactionBean.getTransactionAmount());
		this.setTransactionDate(transactionBean.getTransactionDate());
		this.setUserID(transactionBean.getUserID());
	}
}
