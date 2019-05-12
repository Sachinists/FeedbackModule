package com.example.feedback.bean;

import java.time.LocalDate;


public class FeedbackBean {
	
	private Integer feedbackID;
	private Integer feedback;
	private String comments;
	private LocalDate dateOfFeedback;
	private String chatbotName;
	private String givenBy;
	
	public String getGivenBy() {
		return givenBy;
	}

	public void setGivenBy(String givenBy) {
		this.givenBy = givenBy;
	}

	@Override
	public String toString() {
		return feedbackID + " : " + feedback + " : "  + comments;
	}
	
	public Integer getFeedbackID() {
		return feedbackID;
	}
	public void setFeedbackID(Integer feedbackID) {
		this.feedbackID = feedbackID;
	}
	public Integer getFeedback() {
		return feedback;
	}
	public void setFeedback(Integer feedback) {
		this.feedback = feedback;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}

	public LocalDate getDateOfFeedback() {
		return dateOfFeedback;
	}

	public void setDateOfFeedback(LocalDate dateOfFeedback) {
		this.dateOfFeedback = dateOfFeedback;
	}

	public String getChatbotName() {
		return chatbotName;
	}
	public void setChatbotName(String chatbotName) {
		this.chatbotName = chatbotName;
	}
	
}
