package com.sngular.omb.ombapi.model.request;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class DepositRequestTest {

    public static final Double EXPECTED_AMMOUNT = 200.0;
    private DepositRequest depositRequest;

    @Before
    public void setUp(){
        depositRequest = new DepositRequest(200.0);
    }

    @Test
    public void testDepositRequest(){
        Assertions.assertEquals(EXPECTED_AMMOUNT,depositRequest.getAmount());
    }
}
