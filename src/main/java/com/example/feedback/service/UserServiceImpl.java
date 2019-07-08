package com.example.feedback.service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.feedback.bean.PolicyTakenBean;
import com.example.feedback.bean.UserBean;
import com.example.feedback.dao.UserDAAO;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAAO userDAO;
	
	@Override
	public List<UserBean> getAllUsers() {
		return userDAO.getAllUsers();
	}

	@Override
	public List<PolicyTakenBean> getAllPolicyTakenByUserID(int userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserBean getUserByUserID(int userID) {
		return userDAO.getUserByUserID(userID);
	}

	@Override
	public UserBean getUserByNameDOB(String name, String dob) {
		DateTimeFormatter dFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		UserBean userBean = userDAO.getUserByNameDOB(name);
		if(userBean != null) {
			if(userBean.getDateOfBirth().isEqual(LocalDate.parse(dob, dFormatter))) {
				return userBean;
			}
		}
		return null;
	}

}
