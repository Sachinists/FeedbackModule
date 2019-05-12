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

import com.example.feedback.bean.FeedbackBean;
import com.example.feedback.entity.FeedbackEntity;

@Repository
public class FeedbackDAOImpl implements FeedbackDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<FeedbackBean> getAllFeedbacks() {
		Session session = sessionFactory.openSession();
		List<FeedbackBean> feedBackList = new ArrayList<>();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<FeedbackEntity> criteriaQuery = builder.createQuery(FeedbackEntity.class);
		Root<FeedbackEntity> root = criteriaQuery.from(FeedbackEntity.class);
		criteriaQuery.select(root).orderBy(builder.desc(root.get("feedback")));
		List<FeedbackEntity> empList = session.createQuery(criteriaQuery).list();
		empList.forEach((i) -> {
			FeedbackBean fBean = new FeedbackBean();
			fBean.setFeedbackID(i.getFeedbackID());
			fBean.setFeedback(i.getFeedback());
			fBean.setComments(i.getComments());
			fBean.setDateOfFeedback(i.getDateOfFeedback());
			fBean.setChatbotName(i.getChatbotName());
			fBean.setGivenBy(i.getGivenBy());
			feedBackList.add(fBean);
		});
		session.close();
		return feedBackList;
	}

	@Override
	public boolean addFeedback(FeedbackBean feedbackBean) {
		Session session = null;
		session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		FeedbackEntity feedbackEntity = new FeedbackEntity();
		feedbackEntity.setGivenBy(feedbackBean.getGivenBy());
		feedbackEntity.setComments(feedbackBean.getComments());
		feedbackEntity.setDateOfFeedback(feedbackBean.getDateOfFeedback());
		feedbackEntity.setFeedback(feedbackBean.getFeedback());
		Integer i = (Integer) session.save(feedbackEntity);
		System.out.println(feedbackEntity.toString());
		tx.commit();
		session.close();
		return true;
	}

	@Override
	public boolean clearAll() {
		Session session = null;
		session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.createQuery("delete from FeedbackEntity").executeUpdate();
		tx.commit();
		session.close();
		return true;
	}

}
