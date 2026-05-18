package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.InstLoanAppUsers;

@Repository
public interface InstLoanAppUserRepo extends JpaRepository<InstLoanAppUsers, String> {

}
