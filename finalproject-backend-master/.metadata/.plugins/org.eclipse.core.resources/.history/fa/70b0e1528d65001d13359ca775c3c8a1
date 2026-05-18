package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.exception.UserAlreadyExistException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.JWTRequest;
import com.example.demo.model.JWTResponse;
import com.example.demo.model.InstLoanAppUsers;
import com.example.demo.service.MyUserDetailService;
import com.example.demo.service.InstLoanAppUsersService;
import com.example.demo.util.JWTUtility;


@RestController
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:3000"})
public class InstLoanAppUsersController {
	
	@Autowired
	InstLoanAppUsersService instLoanAppUsersServ;
	
	@Autowired
	AuthenticationManager manager;
	
	@Autowired
	MyUserDetailService userDetailService;
	
	@Autowired
	JWTUtility jwtUtitlity;


	
	@PostMapping("/loanusers")
	public ResponseEntity<InstLoanAppUsers> resgisterUser(@RequestBody InstLoanAppUsers instLoanAppUsers) throws UserAlreadyExistException{
		return new ResponseEntity<InstLoanAppUsers>(instLoanAppUsersServ.registerUser(instLoanAppUsers),HttpStatus.CREATED);
	}
	
	@GetMapping("/loanusers")
	public ResponseEntity<List<InstLoanAppUsers>> getAllUser(){
		return new ResponseEntity<List<InstLoanAppUsers>>(instLoanAppUsersServ.getAllUser(), HttpStatus.OK);
	}
	
	@GetMapping("/loanusers/{emailid}")
	public ResponseEntity<InstLoanAppUsers> findAUserbyId(@PathVariable String emailid) throws UserNotFoundException{
		return new ResponseEntity<InstLoanAppUsers>(instLoanAppUsersServ.findUserbyId(emailid), HttpStatus.OK);
	}
	
	@DeleteMapping("/loanusers/{emailid}")
	public ResponseEntity<InstLoanAppUsers> deleteAUserbyId(@PathVariable String emailid){
		return new ResponseEntity<InstLoanAppUsers>(instLoanAppUsersServ.deleteAUser(emailid),HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/loanusers")
	public ResponseEntity<InstLoanAppUsers> updateAUser(@RequestBody InstLoanAppUsers updatedInstLoanAppUsers){
		return new ResponseEntity<InstLoanAppUsers>(instLoanAppUsersServ.updateAUser(updatedInstLoanAppUsers),HttpStatus.CREATED);
	}
	
	
	@PostMapping("/login")
	public JWTResponse login(@RequestBody JWTRequest request) throws Exception {
		
try {
			
			manager.authenticate(
					new UsernamePasswordAuthenticationToken(request.getEmailid(), request.getPassword())	
					);
			
		}
		catch( BadCredentialsException e ){
			throw new Exception("Wrong_Emailid_or_Password");
		}
		
		UserDetails userdetail = userDetailService.loadUserByUsername(request.getEmailid());
		
		String generateToken = jwtUtitlity.generateToken(userdetail);
		return new JWTResponse(generateToken);

		
	}
	
	
	
	
}
