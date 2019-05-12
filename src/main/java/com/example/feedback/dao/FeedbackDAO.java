package com.example.feedback.dao;

import java.util.List;

import com.example.feedback.bean.FeedbackBean;

public interface FeedbackDAO {
	public List<FeedbackBean> getAllFeedbacks();
	public boolean addFeedback(FeedbackBean feedbackBean);
	public boolean clearAll();
}
