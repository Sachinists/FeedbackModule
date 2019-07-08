package com.example.feedback.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.feedback.bean.UserBean;
import com.example.feedback.service.UserService;

@RestController
public class UserAPI {

	@Autowired
	private UserService userService;
	
	@GetMapping("/getAllUsers")
	@ResponseBody
	public ResponseEntity<List<UserBean>> getAllUsers() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type","application/json");
		return new ResponseEntity<List<UserBean>>(userService.getAllUsers(), headers, HttpStatus.OK);
	}
	
	@PostMapping("/getUserByUserID")
	@ResponseBody
	public ResponseEntity<UserBean> getUserByUSerID(@RequestParam int userID) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type","application/json");
		return new ResponseEntity<UserBean>(userService.getUserByUserID(userID), headers, HttpStatus.OK);
	}
}
