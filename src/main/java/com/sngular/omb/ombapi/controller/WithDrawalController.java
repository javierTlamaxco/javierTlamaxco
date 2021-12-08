package com.sngular.omb.ombapi.controller;

import com.sngular.omb.ombapi.exception.ExceptionFormat;
import com.sngular.omb.ombapi.model.request.WithdrawalRequest;
import com.sngular.omb.ombapi.model.response.WithdrawalResponse;
import com.sngular.omb.ombapi.service.WithDrawalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

/**
 * Service class for withdrawal services.
 * */
@RestController
@CrossOrigin(origins = "*")
@Slf4j
public class WithDrawalController {

    /**Withdrawal Service*/
    @Autowired
    WithDrawalService withDrawalService;

    /**
     * Service for withdrawal with id Client
     *
     * @param accountId Account ID.
     * @param  withdrawalRequest withdrawal request.
     *
     * @return WithdrawalResponse withdrawal Response.
     * @throws ExceptionFormat the exception format
     * */
    @PostMapping("/accounts/{accountId}/withdraw/")
    public WithdrawalResponse postWithdrawal(@PathVariable String accountId, @RequestBody WithdrawalRequest withdrawalRequest) throws ExceptionFormat {
        // log.info(accountId,withdrawalRequest.getAmount());
        return  withDrawalService.withdrawAmount(accountId,withdrawalRequest);
    }


}
