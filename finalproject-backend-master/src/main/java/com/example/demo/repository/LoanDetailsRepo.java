package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.LoanDetails;

@Repository
public interface LoanDetailsRepo extends JpaRepository<LoanDetails, Long>{
	
	List<LoanDetails> findByAccno(Long accno);

}
