package com.sngular.omb.ombapi.controller;

import com.sngular.omb.ombapi.model.Account;
import com.sngular.omb.ombapi.model.request.DepositRequest;
import com.sngular.omb.ombapi.model.response.DepositResponse;
import com.sngular.omb.ombapi.service.DepositService;
import com.sngular.omb.ombapi.util.AccountType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@SpringBootTest
@ActiveProfiles("test")
public class DepositControllerTest {
    @Autowired
    DepositController depositController;

    @MockBean
    DepositService depositService;

    /**
     * DEposit Controller Test
     * */
    @Test
    public void testDepositAmount(){
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        Account account = new Account();
        account.setId("1");
        account.setName("Josua Smith Third");
        account.setAccountType(AccountType.checkingAccount);
        account.setDateBirth("1992-04-30");
        account.setInitialBalance(200.0);
        account.setCurrentBalance(200.0);
        account.setRoutingNumber("12455554118");
        account.setAccountNumber("787878784484");

        DepositRequest depositRequest = new DepositRequest();
        depositRequest.setAmount(50.0);

        DepositResponse depositResponse = new DepositResponse();
        depositResponse.setAccountId("1");
        depositResponse.setCurrentBalance(150.0);

        ResponseEntity<DepositResponse> responseEntity = depositController.postDeposit("1",depositRequest);
        Mockito.when(depositService.makeDeposit("1",depositRequest)).thenReturn(depositResponse);

        Assertions.assertEquals(200,responseEntity.getStatusCodeValue());
    }

}
