package com.example.demo.controller;

import com.example.demo.model.InstLoanAppUsers;
import com.example.demo.service.InstLoanAppUsersService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class InstLoanAppUsersControllerTest {

    private MockMvc mockMvc;
    @Mock
    InstLoanAppUsersService instLoanAppUsersService;
    @InjectMocks
    private InstLoanAppUsersController instLoanAppUsersController;

    private InstLoanAppUsers instLoanAppUsers;
    private List<InstLoanAppUsers> instLoanAppUsersList;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(instLoanAppUsersController).build();
        instLoanAppUsers = new InstLoanAppUsers();
        instLoanAppUsers.setId("Unni123@gmail.com");
        instLoanAppUsers.setName("Unni");
        instLoanAppUsers.setAddress("Kerala");
        instLoanAppUsers.setMobno((long) 1234567891);
        instLoanAppUsers.setAccno((long) (4597953));
        instLoanAppUsers.setPassword("Kerala");

        instLoanAppUsersList = new ArrayList<>();
        instLoanAppUsersList.add(instLoanAppUsers);
    }

    @AfterEach
    public void tearDown() {
    	instLoanAppUsers = null;
    }

    @Test
    public void givenInstLoanAppUsersToSaveThenShouldReturnSavedNetflixUsers() throws Exception {
        when(instLoanAppUsersService.registerUser(any())).thenReturn(instLoanAppUsers);
        mockMvc.perform(post("/loanusers")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(instLoanAppUsers)))
                .andExpect(status().isCreated())
                .andDo(MockMvcResultHandlers.print());
        verify(instLoanAppUsersService).registerUser(any());
    }

    @Test
    public void givenGetAllInstLoanAppUsersThenShouldReturnListOfAllNetflixUsers() throws Exception {
        when(instLoanAppUsersService.getAllUser()).thenReturn(instLoanAppUsersList);
        mockMvc.perform(MockMvcRequestBuilders.get("/loanusers")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(instLoanAppUsers)))
                .andDo(MockMvcResultHandlers.print());
        verify(instLoanAppUsersService).getAllUser();
        verify(instLoanAppUsersService, times(1)).getAllUser();

    }

    @Test
    void givenInstLoanAppUserIdThenShouldReturnRespectiveInstLoanAppUser() throws Exception {
        when(instLoanAppUsersService.findUserbyId(instLoanAppUsers.getId())).thenReturn(instLoanAppUsers);
        mockMvc.perform(get("/loanusers/Unni123@gmail.com"))
                .andExpect(MockMvcResultMatchers.status()
                        .isOk())
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    public void givenInstLoanAppUsersToDeleteThenShouldNotReturnDeletedInstLoanAppUsers() throws Exception {
        when(instLoanAppUsersService.deleteAUser(instLoanAppUsers.getId())).thenReturn(instLoanAppUsers);
        mockMvc.perform(delete("/loanusers/Unni123@gmail.com")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(instLoanAppUsers)))
                .andExpect(MockMvcResultMatchers.status().isAccepted()).andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void givenInstLoanAppUsersToUpdateThenShouldReturnUpdatedInstLoanAppUsers() throws Exception {
        when(instLoanAppUsersService.updateAUser(any())).thenReturn(instLoanAppUsers);
        mockMvc.perform(put("/loanusers").contentType(MediaType.APPLICATION_JSON).content(asJsonString(instLoanAppUsers)))
                .andExpect(status().isCreated()).andDo(MockMvcResultHandlers.print());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}









