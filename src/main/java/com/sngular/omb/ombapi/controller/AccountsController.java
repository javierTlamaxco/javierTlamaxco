package com.sngular.omb.ombapi.controller;

import com.sngular.omb.ombapi.model.Account;
import com.sngular.omb.ombapi.service.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class AccountsController {
        
    @Autowired
    private AccountsService accountsService;

    @GetMapping("/accounts")
    public List<Account> getAccounts() {
        return accountsService.getAccounts();
    }
}
