package com.example.feedback.dao;

import java.util.List;

import com.example.feedback.bean.UserBean;

public interface UserDAAO {

	public List<UserBean> getAllUsers();

	public UserBean getUserByUserID(int userID);
}
