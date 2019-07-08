package com.example.feedback.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.feedback.bean.PolicyBean;
import com.example.feedback.bean.PolicyTakenBean;
import com.example.feedback.dao.PolicyDAO;

@Service
public class PolicyServiceImpl implements PolicyService {

	@Autowired
	private PolicyDAO policyDAO;

	@Override
	public List<PolicyBean> getAllPolicies() {
		return policyDAO.getAllPolicies();
	}

	@Override
	public boolean addPolicy() {
		PolicyBean policyBean = new PolicyBean();
		policyBean.setpDescription("Dummy");
		policyBean.setpName("Demo");
		return policyDAO.addPolicy(policyBean);
	}

	@Override
	public List<PolicyTakenBean> getAllPolicyTaken() {
		return policyDAO.getAllPolicyTaken();
	}

	@Override
	public boolean updatePremiumDate(int policyTakenID) {
		PolicyTakenBean policyTakenBean = policyDAO.getPolicyTakenByID(policyTakenID);
		switch (policyTakenBean.getPremiumType()) {
		case 1:
			policyTakenBean.setPremiumDate(policyTakenBean.getPremiumDate().plusMonths(1));
			break;
		case 2:
			policyTakenBean.setPremiumDate(policyTakenBean.getPremiumDate().plusMonths(3));
			break;
		case 3:
			policyTakenBean.setPremiumDate(policyTakenBean.getPremiumDate().plusMonths(6));
			break;
		case 4:
			policyTakenBean.setPremiumDate(policyTakenBean.getPremiumDate().plusMonths(12));
			break;
		default:
			return false;
		}
		try {
			if(policyDAO.updatePremiumDate(policyTakenBean)) {
				return true;
			}
		}catch (Exception e) {
			return false;
		}
		return false;
	}

}
