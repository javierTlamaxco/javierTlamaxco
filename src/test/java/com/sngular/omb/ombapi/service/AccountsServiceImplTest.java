package com.sngular.omb.ombapi.service;

import com.sngular.omb.ombapi.exception.ExceptionFormat;
import com.sngular.omb.ombapi.model.Account;
import com.sngular.omb.ombapi.repository.AccountsRepository;
import com.sngular.omb.ombapi.service.impl.AccountsServiceImpl;
import com.sngular.omb.ombapi.util.AccountType;
import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ActiveProfiles("test")
public class AccountsServiceImplTest {

    @Rule
    public ExpectedException expectation = ExpectedException.none();

    @InjectMocks
    AccountsServiceImpl accountsServiceImpl;

    @Mock
    AccountsRepository accountsRepository;

    private Account accountOne;
    private Account accountTwo;
    private Account emptyAccount;
    private List<Account> accountList;
    private List<Account> emptyList;

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

    @Test
    public void getAccounts(){

        accountOne = new Account("1","Javier Romero", AccountType.savingAccount,"1988-24-09",100.0,"1234","456","2021-01-12",100.0);
        accountTwo = new Account("2","Antonio Romero", AccountType.checkingAccount,"1994-17-11",1000.0,"7894","457","2021-05-12",1000.0);
        accountList = new ArrayList<>();

        accountList.add(accountOne);
        accountList.add(accountTwo);

        Mockito.when(accountsServiceImpl.getAccounts()).thenReturn(accountList);
         List<Account> listAccountRes =  accountsServiceImpl.getAccounts();
        Mockito.when(accountsRepository.findAll()).thenReturn(accountList);
        Assertions.assertEquals(2,listAccountRes.size());
    }

    @Test
    public void  postAccountsBalance(){
        accountOne = new Account("1","Javier Romero", AccountType.savingAccount,"1988-24-09",100.0,"1234","456","2021-01-12",100.0);
            Mockito.when(accountsServiceImpl.postAccounts(accountOne)).thenReturn(accountOne);
            Account account = accountsServiceImpl.postAccounts(accountOne);
            Assertions.assertEquals(account.getId(),accountOne.getId());
    }

    @Test
    public void  postAccountsBalanceExceptionFormat(){

        Assertions.assertThrows(Exception.class, () -> {
            accountsServiceImpl.postAccounts(accountOne);
        });
    }

    @Test
    public void getAccountsById(){
        accountOne = new Account("1","Javier Romero", AccountType.savingAccount,"1988-24-09",100.0,"1234","456","2021-01-12",100.0);
        //accountsRepository.findById("1");
       // Mockito.when(accountsRepository.findById("1")).thenReturn(java.util.Optional.ofNullable(accountOne));
        Mockito.doReturn(Optional.of(accountOne)).when(accountsRepository).findById("1");
        Optional<Account> returnAccount = accountsServiceImpl.getAccountsById("1");
        Assertions.assertTrue(returnAccount.isPresent());
    }

    @Test
    public void getAccountsByIdEmpty(){
        accountOne = new Account("1","Javier Romero", AccountType.savingAccount,"1988-24-09",100.0,"1234","456","2021-01-12",100.0);
        //accountsRepository.findById("1");
        // Mockito.when(accountsRepository.findById("1")).thenReturn(java.util.Optional.ofNullable(accountOne));
        Mockito.doReturn(Optional.empty()).when(accountsRepository).findById("2");
        Optional<Account> returnAccount = accountsServiceImpl.getAccountsById("1");
        Assertions.assertFalse(returnAccount.isPresent(),"Account not Found");
    }
}
