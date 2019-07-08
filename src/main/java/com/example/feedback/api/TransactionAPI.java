package com.example.feedback.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.feedback.bean.TransactionBean;
import com.example.feedback.service.TransactionService;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
public class TransactionAPI {

	@Autowired
	private TransactionService transactionService;
	
	@GetMapping("/getAllTransaction")
	@ResponseBody
	public ResponseEntity<List<TransactionBean>> getAllTransaction() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type","application/json");
		return new ResponseEntity<List<TransactionBean>>(transactionService.getAllTransaction(), headers, HttpStatus.OK);
	}
	
	@PostMapping("/addTransaction")
	@ResponseBody
	public ResponseEntity<Boolean> addTransaction(@RequestBody TransactionBean transactionBean) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type","application/json");
		return new ResponseEntity<Boolean>(transactionService.addTransaction(transactionBean), headers, HttpStatus.OK);
	}
}
