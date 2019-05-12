package com.example.feedback.bean;

public class FeedCount implements Comparable<FeedCount>{
	private String feedback;
	private int count;
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public int compareTo(FeedCount o) {
		return FeedbackType.valueOf(this.feedback).getValue() - FeedbackType.valueOf(o.feedback).getValue();
	}
	public FeedCount(String feedback, int count) {
		this.feedback = feedback;
		this.count = count;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	
	
	
	
	

	
	
	
}
