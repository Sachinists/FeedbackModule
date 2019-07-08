package com.example.feedback.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.feedback.bean.UserBean;
import com.example.feedback.entity.UserEntity;

@Repository
public class UserDAOImpl implements UserDAAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<UserBean> getAllUsers() {
		System.out.println("in get all user");
		Session session = sessionFactory.openSession();
		List<UserBean> userBeans = new ArrayList<>();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<UserEntity> criteriaQuery = builder.createQuery(UserEntity.class);
		Root<UserEntity> root = criteriaQuery.from(UserEntity.class);
		criteriaQuery.select(root);
		List<UserEntity> empList = session.createQuery(criteriaQuery).list();
		empList.forEach((i) -> {
			userBeans.add(i.toBean());
		});
		session.close();
		return userBeans;
	}

	@Override
	public UserBean getUserByUserID(int userID) {
		Session session = sessionFactory.openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<UserEntity> criteriaQuery = builder.createQuery(UserEntity.class);
		Root<UserEntity> root = criteriaQuery.from(UserEntity.class);
		criteriaQuery.select(root).where(builder.equal(root.get("userID"), userID));
		UserBean userBean = session.createQuery(criteriaQuery).uniqueResult().toBean();
		return userBean;
	}

	@Override
	public UserBean getUserByNameDOB(String name) {
		Session session = sessionFactory.openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<UserEntity> criteriaQuery = builder.createQuery(UserEntity.class);
		Root<UserEntity> root = criteriaQuery.from(UserEntity.class);
		criteriaQuery.select(root).where(builder.equal(root.get("username"), name));
		 UserEntity userBean = session.createQuery(criteriaQuery).uniqueResult(); 
		 if(userBean != null) {
			 return userBean.toBean();
		 }
		return null;
	}

}
