package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.LoanDetails;
import com.example.demo.repository.LoanDetailsRepo;

@RestController
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:3000"})
public class LoanDetailsController {
	
	@Autowired
	private LoanDetailsRepo loanDetailsRepo;
	
	@PostMapping("/loandetails")
	LoanDetails newLoanDetails(@RequestBody LoanDetails newLoanDetails) {
		return loanDetailsRepo.save(newLoanDetails);
		
	}
	
	@GetMapping("/loandetails")
	List<LoanDetails> getAllLoanDetails(){
		return loanDetailsRepo.findAll();
	}
	
	@PutMapping("/loandetails")
	LoanDetails updateLoanDetails(@RequestBody LoanDetails loanToUpdate) {
//		LoanDetails updatedLoanDetails = null;
		LoanDetails dbLoan = loanDetailsRepo.findById(loanToUpdate.getLoanappno()).get();
		dbLoan.setStatus(loanToUpdate.getStatus());
		LoanDetails updatedLoanDetails = loanDetailsRepo.save(dbLoan);
		return updatedLoanDetails;
	}
	
	@GetMapping("/loandetails/{loanappno}")
	LoanDetails getALoanDetails(@PathVariable Long loanappno) {
		return loanDetailsRepo.findById(loanappno).get();
	}
	
	@GetMapping("/loandetails/accno")
	public ResponseEntity<List<LoanDetails>> findByAccNo(@RequestParam Long accno){
		return new ResponseEntity<List<LoanDetails>>(loanDetailsRepo.findByAccno(accno), HttpStatus.OK);
	}
	
	
}
