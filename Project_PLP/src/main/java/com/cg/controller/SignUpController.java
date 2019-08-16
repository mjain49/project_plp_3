package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.bean.*;
import com.cg.service.SignUpServiceImpl;


@RestController
@RequestMapping("/")
public class SignUpController {

	@Autowired
	private SignUpServiceImpl service;
	
	@PostMapping(value="/addUser",consumes={"application/json"})
	public ResponseEntity<String> addUser(@RequestBody User1WithSecurityQuestions user) {
		
		if(service.userExists(user.getUser().getEmailid()))
			return new ResponseEntity<String>("User Already Exists",HttpStatus.BAD_REQUEST);
		else {
			if(service.addUser(user.getUser()) && service.addSecurityAns(user.getSecurity()))
			return new ResponseEntity<String>("User Added",HttpStatus.OK);
			else
			return new ResponseEntity<String>("Error Occured",HttpStatus.CONFLICT);
		}
	
	}
	
	@PostMapping(value="/addAdmin",consumes={"application/json"})
	public ResponseEntity<String> addAdmin(@RequestBody AdminWithSecurityQuestions admin) {
		
		if(service.adminExists(admin.getAdmin().getEmailid()))
			return new ResponseEntity<String>("Admin Already Exists",HttpStatus.BAD_REQUEST);
		else{
			if(service.addAdmin(admin.getAdmin()) && service.addSecurityAns(admin.getSecurity()))
			return new ResponseEntity<String>("Admin Added",HttpStatus.OK);
			else
			return new ResponseEntity<String>("Error Occured",HttpStatus.CONFLICT);
		}
	}
	@PostMapping(value="/addMerchant",consumes={"application/json"})
	public ResponseEntity<String> addMerchant(@RequestBody MerchantWithSecurityQuestions merchant) {
		
		if(service.merchantExists(merchant.getMerchant().getEmailid()))
			return new ResponseEntity<String>("Merchant Already Exists",HttpStatus.BAD_REQUEST);
		else{
			if(service.addMerchant(merchant.getMerchant()) && service.addSecurityAns(merchant.getSecurity()))
			return new ResponseEntity<String>("Merchant Added",HttpStatus.OK);
			return new ResponseEntity<String>("Error Occured",HttpStatus.CONFLICT);
		}
	}
}
