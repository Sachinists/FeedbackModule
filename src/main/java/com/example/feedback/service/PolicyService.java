package com.example.feedback.service;

import java.util.List;

import com.example.feedback.bean.PolicyBean;
import com.example.feedback.bean.PolicyTakenBean;

public interface PolicyService {

	public List<PolicyBean> getAllPolicies();
	public boolean addPolicy();
	public List<PolicyTakenBean> getAllPolicyTaken();
	public boolean updatePremiumDate(int policyID);
	
	
}
