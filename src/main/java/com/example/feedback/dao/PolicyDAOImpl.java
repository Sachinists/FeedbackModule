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

import com.example.feedback.bean.PolicyBean;
import com.example.feedback.bean.PolicyTakenBean;
import com.example.feedback.entity.PolicyEntity;
import com.example.feedback.entity.PolicyTakenEntity;

@Repository
public class PolicyDAOImpl implements PolicyDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<PolicyBean> getAllPolicies() {
		System.out.println("in get all policy");
		Session session = sessionFactory.openSession();
		List<PolicyBean> policyBeans = new ArrayList<>();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<PolicyEntity> criteriaQuery = builder.createQuery(PolicyEntity.class);
		Root<PolicyEntity> root = criteriaQuery.from(PolicyEntity.class);
		criteriaQuery.select(root);
		List<PolicyEntity> empList = session.createQuery(criteriaQuery).list();
		empList.forEach((i) -> {
			policyBeans.add(i.toBean());
		});
		session.close();
		return policyBeans;
	}

	@Override
	public boolean addPolicy(PolicyBean policyBean) {
		Session session = null;
		session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		PolicyEntity policyEntity = new PolicyEntity();
		policyEntity.set(policyBean);
//		Integer i = (Integer) 
		session.persist(policyEntity);
		tx.commit();
		session.close();
		return true;
	}

	@Override
	public List<PolicyTakenBean> getAllPolicyTaken() {
		System.out.println("in get all policy taken");
		Session session = sessionFactory.openSession();
		List<PolicyTakenBean> policyTakenBeans = new ArrayList<>();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<PolicyTakenEntity> criteriaQuery = builder.createQuery(PolicyTakenEntity.class);
		Root<PolicyTakenEntity> root = criteriaQuery.from(PolicyTakenEntity.class);
		criteriaQuery.select(root);
		List<PolicyTakenEntity> empList = session.createQuery(criteriaQuery).list();
		empList.forEach((i) -> {
			policyTakenBeans.add(i.toBean());
		});
		session.close();
		return policyTakenBeans;
	}

	@Override
	public PolicyTakenBean getPolicyTakenByID(int policyTakenID) {
		Session session = sessionFactory.openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<PolicyTakenEntity> criteriaQuery = builder.createQuery(PolicyTakenEntity.class);
		Root<PolicyTakenEntity> root = criteriaQuery.from(PolicyTakenEntity.class);
		criteriaQuery.select(root).where(builder.equal(root.get("policyTakenID"), policyTakenID));
		PolicyTakenBean policyTakenBean = session.createQuery(criteriaQuery).uniqueResult().toBean();
		session.close();
		return policyTakenBean;
	}

	@Override
	public boolean updatePremiumDate(PolicyTakenBean policyTakenBean) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<PolicyTakenEntity> criteriaQuery = builder.createQuery(PolicyTakenEntity.class);
		Root<PolicyTakenEntity> root = criteriaQuery.from(PolicyTakenEntity.class);
		criteriaQuery.select(root).where(builder.equal(root.get("policyTakenID"), policyTakenBean.getPolicyTakenID()));
		PolicyTakenEntity pEntity = session.createQuery(criteriaQuery).uniqueResult();
		pEntity.setPremiumDate(policyTakenBean.getPremiumDate());
		session.persist(pEntity);
		tx.commit();
		session.close();
		return true;
	}

}
