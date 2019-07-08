package com.example.feedback.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.feedback.bean.FeedCount;
import com.example.feedback.bean.FeedbackBean;
import com.example.feedback.service.FeedbackService;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
public class FeedbackAPI {

	@Autowired
	private FeedbackService feedbackService;
	
	@GetMapping("/getAllFeedbacks")
	@ResponseBody
	public ResponseEntity<List<FeedbackBean>> getAllFeedbacks() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type","application/json");
		return new ResponseEntity<List<FeedbackBean>>(feedbackService.getAllFeedbacks(), headers, HttpStatus.OK);
	}
	
	@PostMapping("/addFeedback")
	@ResponseBody
	public ResponseEntity<Boolean> addFeedback(@RequestParam int feed,String comments,String givenby) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type","application/json");
		return new ResponseEntity<Boolean>(feedbackService.addFeedback(feed, comments, givenby), headers, HttpStatus.OK);
	}

	@GetMapping("/getFeedbackCount")
	@ResponseBody
	public ResponseEntity<List<FeedCount>> getFeedbackCount() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type","application/json");
		return new ResponseEntity<List<FeedCount>>(feedbackService.getFeedCount(), headers, HttpStatus.OK);
	}
	
	@GetMapping("/clearAll")
	@ResponseBody
	public ResponseEntity<Boolean> clearAll() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type","application/json");
		return new ResponseEntity<Boolean>(feedbackService.clearAll(), headers, HttpStatus.OK);
	}
}
