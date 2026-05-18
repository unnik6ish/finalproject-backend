package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.exception.UserAlreadyExistException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.InstLoanAppUsers;
import com.example.demo.repository.InstLoanAppUserRepo;

@ExtendWith(MockitoExtension.class)
public class InstLoanAppUsersServiceTest {
	
	@Mock
    private InstLoanAppUserRepo netRepo;
	
	@InjectMocks
    private InstLoanAppUsersUserServiceImpl  appUsersUserServiceImpl;
    private InstLoanAppUsers instLoanAppUsers1 ,instLoanAppUsers2;
    private List<InstLoanAppUsers> instLoanAppUsersList;
    private Optional optional;

    
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        instLoanAppUsers1 = new InstLoanAppUsers("Unni123@gmail.com", "Unni", "Unni", (long) 1234567891, (long) (4597953), "Unni@123");
        instLoanAppUsers2 = new InstLoanAppUsers("Krish123@gmail.com", "Krish","Chennai",(long) 254136413, (long) (54641321),"Krish@123");
        optional = Optional.of(instLoanAppUsers1);
    }


    @AfterEach
    public void tearDown() {
    	instLoanAppUsers1 = null;
    }

    @Test
    public void givenInstLoanAppUserToSaveThenShouldReturnSavedWalletUser() throws UserAlreadyExistException {
        when(netRepo.save(any())).thenReturn(instLoanAppUsers1);
        assertEquals(instLoanAppUsers1, appUsersUserServiceImpl.registerUser(instLoanAppUsers1));
        verify(netRepo, times(1)).save(any());
    }

    @Test
    public void givenWalletUserToSaveThenShouldNotReturnSavedInstLoanAppUser() {
        when(netRepo.save(any())).thenThrow(new RuntimeException());
        Assertions.assertThrows(RuntimeException.class,() -> {
        	appUsersUserServiceImpl.registerUser(instLoanAppUsers1);
        });
        verify(netRepo, times(1)).save(any());
    }

    @Test
    public void givenGetAllInstLoanAppUsersThenShouldReturnListOfAllInstLoanAppUsers() {
    	netRepo.save(instLoanAppUsers1);
        //stubbing the mock to return specific data
        when(netRepo.findAll()).thenReturn(instLoanAppUsersList);
        List<InstLoanAppUsers> walletUserList1 = appUsersUserServiceImpl.getAllUser();
        assertEquals(instLoanAppUsersList, walletUserList1);
        verify(netRepo, times(1)).save(instLoanAppUsers1);
        verify(netRepo, times(1)).findAll();
    }

    @Test
    public void givenInstLoanAppUserIdThenShouldReturnRespectiveInstLoanAppUser() throws UserNotFoundException {
        when(netRepo.findById(anyString())).thenReturn(Optional.of(instLoanAppUsers1));
        InstLoanAppUsers retrievedWalletUser = appUsersUserServiceImpl.findUserbyId(instLoanAppUsers1.getId());
        verify(netRepo, times(1)).findById(anyString());

    }

   
    @Test
    void givenInstLoanAppUserIdToDeleteThenShouldReturnDeletedInstLoanAppUser() {
        when(netRepo.findById(instLoanAppUsers1.getId())).thenReturn(optional);
        InstLoanAppUsers deletedInstLoanAppUser = appUsersUserServiceImpl.deleteAUser("Unni123@gmail.com");
        assertEquals("Unni123@gmail.com", deletedInstLoanAppUser.getId());

        verify(netRepo, times(2)).findById(instLoanAppUsers1.getId());
        verify(netRepo, times(1)).deleteById(instLoanAppUsers1.getId());
    }

    @Test
    void givenInstLoanAppUserIdToDeleteThenShouldNotReturnDeletedNInstLoanAppUser() {
        when(netRepo.findById(instLoanAppUsers1.getId())).thenReturn(Optional.empty());
        InstLoanAppUsers deletedInstLoanAppUser = appUsersUserServiceImpl.deleteAUser("Unni123@gmail.com");
        verify(netRepo, times(1)).findById(instLoanAppUsers1.getId());
    }
    
    @Test
    public void giveInstLoanAppUserToUpdateThenShouldReturnUpdatedInstLoanAppUser() {
        when(netRepo.findById(instLoanAppUsers1.getId())).thenReturn(optional);
        when(netRepo.save(instLoanAppUsers1)).thenReturn(instLoanAppUsers1);
        instLoanAppUsers1.setId("Unni123@gmail.com");
        InstLoanAppUsers walletUsers1 = appUsersUserServiceImpl.updateAUser(instLoanAppUsers1);
        assertEquals(walletUsers1.getId(), "Unni123@gmail.com");
        verify(netRepo, times(1)).save(instLoanAppUsers1);
        verify(netRepo, times(2)).findById(instLoanAppUsers1.getId());
    }

    @Test
    public void givenInstLoanAppUserToUpdateThenShouldNotReturnUpdatedInstLoanAppUser() {
        when(netRepo.findById(instLoanAppUsers1.getId())).thenReturn(Optional.empty());
        InstLoanAppUsers walletUsers1 = appUsersUserServiceImpl.updateAUser(instLoanAppUsers1);
        assertNull(walletUsers1);
        verify(netRepo, times(1)).findById(instLoanAppUsers1.getId());
    }


}
