package com.example.feedback.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.feedback.bean.FeedCount;
import com.example.feedback.bean.FeedbackBean;
import com.example.feedback.bean.FeedbackType;
import com.example.feedback.dao.FeedbackDAO;

@Service
public class FeedbackServiceImpl implements FeedbackService{

	@Autowired
	private FeedbackDAO feedbackDAO;
	
	@Override
	public List<FeedbackBean> getAllFeedbacks() {
		List<FeedbackBean> fList = feedbackDAO.getAllFeedbacks();
		fList.sort(new Comparator<FeedbackBean>() {
			@Override
			public int compare(FeedbackBean o1, FeedbackBean o2) {
				return o2.getDateOfFeedback().compareTo(o1.getDateOfFeedback());
			}
		});
		return fList;
	}

	@Override
	public boolean addFeedback(int feedback, String comments,String givenby) {
		FeedbackBean feedbackBean = new FeedbackBean();
		feedbackBean.setComments(comments);
		feedbackBean.setFeedback(feedback);
		feedbackBean.setGivenBy(givenby);
		LocalDate date = LocalDate.now();
		feedbackBean.setDateOfFeedback(date);
		boolean res = true;
		try {
			feedbackDAO.addFeedback(feedbackBean);
		}catch(Exception exception) {
			res = false;
			System.out.println(exception.getMessage());
		}
		return res;
	}

	@Override
	public List<FeedCount> getFeedCount() {
		List<FeedCount> fCountList = new ArrayList<>();
		List<FeedbackBean> fList = feedbackDAO.getAllFeedbacks();
		int[] temp = new int[6];
		for(FeedbackBean fBean : fList) {
			temp[fBean.getFeedback()]++;
		}
		for (int i = 0; i < temp.length; i++) {
			FeedCount fCount = new FeedCount(FeedbackType.valueOf(i).get().name(),temp[i]);
			fCountList.add(fCount);
		}
		Collections.sort(fCountList);
		return fCountList;
	}

	@Override
	public boolean clearAll() {
		try {
			feedbackDAO.clearAll();
		}catch(Exception exception) {
			System.out.println(exception.getMessage());
			return false;
		}
		return true;
	}

}
