package com.example.feedback.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.example.feedback.bean.PolicyTakenBean;

@Entity
@Table(name = "policyTakenDetails")
@GenericGenerator(name = "pkgen", strategy = "increment")
public class PolicyTakenEntity {

	@Id
	@GeneratedValue(generator = "pkgen")
	private int policyTakenID;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="policyID")
	private PolicyEntity policyEntity;
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

	public PolicyEntity getPolicyEntity() {
		return policyEntity;
	}
	public void setPolicyEntity(PolicyEntity policyEntity) {
		this.policyEntity = policyEntity;
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
	
	public PolicyTakenBean toBean() {
		PolicyTakenBean policyTakenBean = new PolicyTakenBean();
		policyTakenBean.setEndDate(this.getEndDate());
		policyTakenBean.setPolicyAmount(this.getPolicyAmount());
		policyTakenBean.setPolicyBean(this.getPolicyEntity().toBean());
		policyTakenBean.setPolicyTakenID(this.getPolicyTakenID());
		policyTakenBean.setPremiumAmount(this.getPremiumAmount());
		policyTakenBean.setStartDate(this.getStartDate());
		policyTakenBean.setPremiumDate(this.getPremiumDate());
		policyTakenBean.setTenure(this.getTenure());
		policyTakenBean.setPremiumType(this.getPremiumType());
		return policyTakenBean;
	}
}
