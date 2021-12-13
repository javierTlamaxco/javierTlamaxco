package com.sngular.omb.ombapi.controller;

import com.sngular.omb.ombapi.exception.ExceptionFormat;
import com.sngular.omb.ombapi.model.Account;
import com.sngular.omb.ombapi.service.AccountsService;
import com.sngular.omb.ombapi.util.AccountType;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
public class AccountsControllerTest {

    private Account accountOne;
    private Account accountTwo;
    private Account emptyAccount;
    private List<Account> accountList;
    private List<Account> emptyList;

    @InjectMocks
    AccountsController accountsController;

    @Mock
    AccountsService accountsService;

    @Before
    public void setUp(){
        accountOne = new Account("1","Javier Romero", AccountType.savingAccount,"1988-24-09",100.0,"1234","456","2021-01-12",100.0);
        accountTwo = new Account("2","Antonio Romero", AccountType.checkingAccount,"1994-17-11",1000.0,"7894","457","2021-05-12",1000.0);
        emptyAccount = new Account();
        accountList = new ArrayList<>();

        accountList.add(accountOne);
        accountList.add(accountTwo);
        emptyList = new ArrayList<>();
    }

/*
    @Test
    public void getAccounts_test_OK(){
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        ResponseEntity<List<Account>> responseEntity = accountsController.getAccounts();
        Mockito.when(accountsService.getAccounts()).thenReturn(accountList);

        Assertions.assertEquals(200,responseEntity.getStatusCodeValue());
    }
*/

    @Test
    public void getAccounts_test_Not_Content(){
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        ResponseEntity<List<Account>> responseEntity = accountsController.getAccounts();
        Mockito.when(accountsService.getAccounts()).thenReturn(null);

        Assertions.assertEquals(204,responseEntity.getStatusCodeValue());
    }

/*    @Test
    public void getAccountId_OK(){
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        ResponseEntity<Account> responseEntity = accountsController.getAccounts("1");

        Mockito.when(accountsService.getAccountsById("1")).thenReturn(java.util.Optional.ofNullable(accountOne));

        Assertions.assertEquals(200,responseEntity.getStatusCodeValue());
    }*/

    @Test
    public void getAccountId_Not_Found(){

      /*  MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        ResponseEntity<Account> responseEntity = accountsController.getAccounts("3");*/

        //Mockito.when(accountsService.getAccountsById("3")).thenThrow(ExceptionFormat.class);

       //Throwable exception =
        Assertions.assertThrows(ExceptionFormat.class, () ->{
            accountsController.getAccounts("3");
        });
       //Assertions.assertEquals("The given account identifier was not found",exception.getMessage());
    }


}
