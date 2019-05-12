package com.example.feedback.service;

import java.util.List;

import com.example.feedback.bean.FeedCount;
import com.example.feedback.bean.FeedbackBean;

public interface FeedbackService {
	public List<FeedbackBean> getAllFeedbacks();
	public boolean addFeedback(int feedback, String comments,String chatbotname);
	public List<FeedCount> getFeedCount();
	public boolean clearAll();
}
