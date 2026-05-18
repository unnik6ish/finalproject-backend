package com.example.demo.repositoryTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.InstLoanAppUsers;
import com.example.demo.repository.InstLoanAppUserRepo;

@SpringBootTest
public class InstLoanAppUserRepoTest {
		
	@Autowired
    private InstLoanAppUserRepo instLoanAppUserRepo;
    private InstLoanAppUsers instLoanAppUsers;

    @BeforeEach
    public void setUp() {
    	instLoanAppUsers = new InstLoanAppUsers();
    	instLoanAppUsers.setId("Unni123@gmail.com");
    	instLoanAppUsers.setName("Unni");
    	instLoanAppUsers.setAddress("Kerala");
    	instLoanAppUsers.setMobno((long) 1234567891);
    	instLoanAppUsers.setAccno((long) (4597953));
    	instLoanAppUsers.setPassword("Unni@123");

    }
    
    @AfterEach
    public void tearDown() {
    	instLoanAppUserRepo.deleteAll();
    	instLoanAppUsers = null;
    }
    
//    @Test
//    public void givenInstLoanAppUserToSaveThenShouldReturnSavedInstLoanAppUser() {
//    	instLoanAppUserRepo.save(instLoanAppUsers);
//    	InstLoanAppUsers fetchedUsers = instLoanAppUserRepo.findById(instLoanAppUsers.getId()).get();
//        assertEquals(16, fetchedUsers.getId().length());
//    }


    @Test
    public void givenGetAllInstLoanAppUsersThenShouldReturnListOfAllInstLoanAppUsers() {
    	InstLoanAppUsers instLoanAppUsers1 = new InstLoanAppUsers("Unni123@gmail.com", "Unni", "Kerala", (long) 1234567891, (long) (4597953), "Unni@123");
    	InstLoanAppUsers instLoanAppUsers2 = new InstLoanAppUsers("Krish123@gmail.com", "Krish","Chennai",(long) 254136413, (long) (54641321),"Krish@123");
    	instLoanAppUserRepo.save(instLoanAppUsers1);
    	instLoanAppUserRepo.save(instLoanAppUsers2);

        List<InstLoanAppUsers> blogList = (List<InstLoanAppUsers>)  instLoanAppUserRepo.findAll();
        assertEquals("Unni", blogList.get(1).getName());
    }

    @Test
    public void givenInstLoanAppUserIdThenShouldReturnRespectiveInstLoanAppUser() {
    	InstLoanAppUsers instLoanAppUsers1 = new InstLoanAppUsers("Unni123@gmail.com", "Unni", "Kerala", (long) 1234567891, (long) (4597953), "Unni@123");
    	InstLoanAppUsers instLoanAppUsers2 = instLoanAppUserRepo.save(instLoanAppUsers1);
        Optional<InstLoanAppUsers> optional = instLoanAppUserRepo.findById(instLoanAppUsers2.getId());
        assertEquals(instLoanAppUsers2.getId(), optional.get().getId());
        assertEquals(instLoanAppUsers2.getName(), optional.get().getName());
        assertEquals(instLoanAppUsers2.getAddress(), optional.get().getAddress());
        assertEquals(instLoanAppUsers2.getAccno(), optional.get().getAccno());
        assertEquals(instLoanAppUsers2.getMobno(), optional.get().getMobno());
        assertEquals(instLoanAppUsers2.getPassword(), optional.get().getPassword());

    }
    
    @Test
    public void givenInstLoanAppUserIdToDeleteThenShouldReturnDeletedInstLoanAppUser() {
    	InstLoanAppUsers loanAppUsers = new InstLoanAppUsers("Unni123@gmail.com", "Unni", "Kerala", (long) 1234567891, (long) (4597953), "Unni@123");
    	instLoanAppUserRepo.save(loanAppUsers);
    	instLoanAppUserRepo.deleteById(loanAppUsers.getId());
        Optional optional = instLoanAppUserRepo.findById(loanAppUsers.getId());
        assertEquals(Optional.empty(), optional);
    }



    
}