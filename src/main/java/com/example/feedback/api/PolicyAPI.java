package com.example.feedback.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.feedback.bean.PolicyBean;
import com.example.feedback.bean.PolicyTakenBean;
import com.example.feedback.service.PolicyService;

@RestController
public class PolicyAPI {

	@Autowired
	private PolicyService policyService;
	
	@GetMapping("/getAllPolicies")
	@ResponseBody
	public ResponseEntity<List<PolicyBean>> getAllPolicies() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type","application/json");
		return new ResponseEntity<List<PolicyBean>>(policyService.getAllPolicies(), headers, HttpStatus.OK);
	}
	
	@GetMapping("/getAllPoliciesTaken")
	@ResponseBody
	public ResponseEntity<List<PolicyTakenBean>> getAllPoliciesTaken() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type","application/json");
		return new ResponseEntity<List<PolicyTakenBean>>(policyService.getAllPolicyTaken(), headers, HttpStatus.OK);
	}
	
	@GetMapping("/addPolicy")
	@ResponseBody
	public ResponseEntity<Boolean> addPolicy() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type","application/json");
		return new ResponseEntity<Boolean>(policyService.addPolicy(), headers, HttpStatus.OK);
	}
}
