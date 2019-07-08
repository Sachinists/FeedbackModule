package com.example.feedback.service;

import java.util.List;

import com.example.feedback.bean.PolicyTakenBean;
import com.example.feedback.bean.UserBean;

public interface UserService {

	public List<UserBean> getAllUsers();
	public List<PolicyTakenBean> getAllPolicyTakenByUserID(int userID);
	public UserBean getUserByUserID(int userID);
}
