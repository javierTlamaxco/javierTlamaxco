package com.sngular.omb.ombapi.model.response;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class DepositResponseTest {
    public static final String EXPECTED_ID = "1";
    public static final Double EXECTED_CURRENT_BALANCE = 200.0;

    private DepositResponse depositResponse;

    @Before
    public void setUp(){
        depositResponse = new DepositResponse("1",200.0);
    }

    @Test
    public void depositResponseTest(){
        Assertions.assertEquals(EXPECTED_ID,depositResponse.getAccountId());
        Assertions.assertEquals(EXECTED_CURRENT_BALANCE,depositResponse.getCurrentBalance());
    }
}
