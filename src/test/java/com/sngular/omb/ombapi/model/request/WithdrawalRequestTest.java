package com.sngular.omb.ombapi.model.request;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class WithdrawalRequestTest {

    public static final Double EXPECTED_AMMOUNT = 200.0;
    private WithdrawalRequest withdrawalRequest;

    @Before
    public void setUp(){
        withdrawalRequest = new WithdrawalRequest(200.0);
    }

    @Test
    public void testWithdrawalRequest(){
        Assertions.assertEquals(EXPECTED_AMMOUNT,withdrawalRequest.getAmount());
    }
}
