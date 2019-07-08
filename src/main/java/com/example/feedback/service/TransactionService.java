package com.example.feedback.service;

import java.util.List;

import com.example.feedback.bean.TransactionBean;

public interface TransactionService {

	public List<TransactionBean> getAllTransaction();
	public boolean addTransaction(TransactionBean transactionBean);
}
