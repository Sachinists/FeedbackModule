package com.example.feedback.dao;

import java.util.List;

import com.example.feedback.bean.PolicyBean;
import com.example.feedback.bean.PolicyTakenBean;

public interface PolicyDAO {

	public List<PolicyBean> getAllPolicies();
	public boolean addPolicy(PolicyBean policyBean);
	public List<PolicyTakenBean> getAllPolicyTaken();
	public PolicyTakenBean getPolicyTakenByID(int policyTakenID);
	public boolean updatePremiumDate(PolicyTakenBean policyTakenBean);
	
}
