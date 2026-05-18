package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.UserAlreadyExistException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.InstLoanAppUsers;
import com.example.demo.repository.InstLoanAppUserRepo;

@Service
public class InstLoanAppUsersUserServiceImpl implements InstLoanAppUsersService {
	
	@Autowired
	InstLoanAppUserRepo instLoanAppUserRepo;
	
	@Override
	public InstLoanAppUsers registerUser(InstLoanAppUsers instLoanAppUsers) throws UserAlreadyExistException {
		return instLoanAppUserRepo.save(instLoanAppUsers);
	}

	@Override
	public InstLoanAppUsers findUserbyId(String emailid) throws UserNotFoundException {
		return instLoanAppUserRepo.findById(emailid).get();
	}

	@Override
	public List<InstLoanAppUsers> getAllUser() {
		return instLoanAppUserRepo.findAll();
	}

	@Override
	public InstLoanAppUsers deleteAUser(String emailid) {
		InstLoanAppUsers deletedInstLoanAppUsers = null;
		
		Optional optional = instLoanAppUserRepo.findById(emailid);
		
		if(optional.isPresent()) {
			deletedInstLoanAppUsers = instLoanAppUserRepo.findById(emailid).get();
			instLoanAppUserRepo.deleteById(emailid);
		}
		
		return deletedInstLoanAppUsers;
	}

	@Override
	public InstLoanAppUsers updateAUser(InstLoanAppUsers instLoanAppUsers) {
		InstLoanAppUsers updatedInstLoanAppUsers = null;
		
		Optional optional = instLoanAppUserRepo.findById(instLoanAppUsers.getId());
		
		if (optional.isPresent()) {
			InstLoanAppUsers getUser = instLoanAppUserRepo.findById(instLoanAppUsers.getId()).get();
			getUser.setName(instLoanAppUsers.getName());
			getUser.setAddress(instLoanAppUsers.getAddress());
			getUser.setAccno(instLoanAppUsers.getAccno());
			getUser.setMobno(instLoanAppUsers.getMobno());
			getUser.setPassword(instLoanAppUsers.getPassword());
			
			updatedInstLoanAppUsers = instLoanAppUserRepo.save(getUser);
		}
		
		return updatedInstLoanAppUsers;
	}

	
	
}
