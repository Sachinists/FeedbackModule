package com.example.feedback.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.feedback.bean.TransactionBean;
import com.example.feedback.entity.TransactionEntity;

@Repository
public class TransactionDAOImpl implements TransactionDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<TransactionBean> getAllTransaction() {
		System.out.println("in get all transaction");
		Session session = sessionFactory.openSession();
		List<TransactionBean> transactionBeans = new ArrayList<>();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<TransactionEntity> criteriaQuery = builder.createQuery(TransactionEntity.class);
		Root<TransactionEntity> root = criteriaQuery.from(TransactionEntity.class);
		criteriaQuery.select(root);
		List<TransactionEntity> empList = session.createQuery(criteriaQuery).list();
		empList.forEach((i) -> {
			transactionBeans.add(i.toBean());
		});
		session.close();
		return transactionBeans;
	}

	@Override
	public boolean addTransaction(TransactionBean transactionBean) {
		Session session = null;
		session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		TransactionEntity transactionEntity = new TransactionEntity();
		transactionEntity.set(transactionBean);
//		Integer i = (Integer) 
		session.persist(transactionEntity);
		tx.commit();
		session.close();
		return true;
	}

}
