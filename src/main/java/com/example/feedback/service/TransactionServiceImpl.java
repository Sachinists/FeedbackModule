package com.example.feedback.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.feedback.bean.TransactionBean;
import com.example.feedback.dao.TransactionDAO;
@Service
public class TransactionServiceImpl implements TransactionService{

	@Autowired
	private TransactionDAO transactionDAO;
	
	@Autowired
	private PolicyService policyService;
	
	@Override
	public List<TransactionBean> getAllTransaction() {
		return transactionDAO.getAllTransaction(); 
	}

	@Override
	public boolean addTransaction(TransactionBean transactionBean) {
		transactionBean.setTransactionDate(LocalDate.now());
		boolean flag = transactionDAO.addTransaction(transactionBean);
		if(flag) {
			policyService.updatePremiumDate(transactionBean.getPolicyTakenID());
		}
		return flag;
	}

}
