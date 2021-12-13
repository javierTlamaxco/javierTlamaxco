package com.sngular.omb.ombapi.service;

import com.sngular.omb.ombapi.model.Account;
import com.sngular.omb.ombapi.model.response.DepositResponse;
import com.sngular.omb.ombapi.repository.AccountsRepository;
import com.sngular.omb.ombapi.service.impl.DepositServiceImpl;
import com.sngular.omb.ombapi.util.AccountType;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;

@SpringBootTest
@ActiveProfiles("test")
public class DepositServiceImplTest {

    @Rule
    public ExpectedException expectation = ExpectedException.none();

    @InjectMocks
    DepositServiceImpl depositService;

    @Mock
    AccountsRepository accountsRepository;

    private DepositResponse depositResponse;

    private Account accountOne;
    @Before
    public void setUp(){
        accountOne = new Account("1","Javier Romero", AccountType.savingAccount,"1988-24-09",100.0,"1234","456","2021-01-12",100.0);

        emptyAccount = new Account();
        accountList = new ArrayList<>();

        accountList.add(accountOne);
        accountList.add(accountTwo);
        emptyList = new ArrayList<>();
    }
}
