package com.example.feedback.dao;

import java.util.List;

import com.example.feedback.bean.TransactionBean;

public interface TransactionDAO {

	public List<TransactionBean> getAllTransaction();
	public boolean addTransaction(TransactionBean transactionBean);
	
}
