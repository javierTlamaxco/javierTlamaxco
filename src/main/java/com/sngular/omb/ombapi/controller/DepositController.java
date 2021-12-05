package com.sngular.omb.ombapi.controller;

import com.sngular.omb.ombapi.exception.ExceptionFormat;
import com.sngular.omb.ombapi.model.request.DepositRequest;
import com.sngular.omb.ombapi.model.response.DepositResponse;
import com.sngular.omb.ombapi.service.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * Controller class for deposit services.
 * */
@RestController
@CrossOrigin(origins = "*")
public class DepositController {

    /**Deposit Service*/
    @Autowired
    private DepositService depositService;

    /**
     * Service for deposits with id Client
     *
     * @param accountId Account ID.
     * @param  depositRequest deposit request.
     *
     * @return DepositResponse deposit Response.
     * @throws ExceptionFormat the exception format
     * */
    @PostMapping("/accounts/{accountId}/deposit")
    public DepositResponse postDeposit(@PathVariable String accountId, @RequestBody DepositRequest depositRequest) throws ExceptionFormat {
        return depositService.makeDeposit(accountId,depositRequest);
    }
}
