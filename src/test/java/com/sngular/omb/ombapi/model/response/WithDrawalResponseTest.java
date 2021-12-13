package com.sngular.omb.ombapi.model.response;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class WithDrawalResponseTest {
    public static final String EXPECTED_ACCOUNT_ID = "1";
    public static final Double EXPECTED_CURRENT_BALANCE = 200.0;

    private WithdrawalResponse withdrawalResponse;

    @Before
    public void setUp(){
        withdrawalResponse = new WithdrawalResponse("1",200.0);
    }

    @Test
    public void withdrawalResponseTest(){
        Assertions.assertEquals(EXPECTED_ACCOUNT_ID,withdrawalResponse.getAccountId());
        Assertions.assertEquals(EXPECTED_CURRENT_BALANCE,withdrawalResponse.getCurrentBalance());
    }
}
