package com.sngular.omb.ombapi.service;

import com.sngular.omb.ombapi.exception.ExceptionFormat;
import com.sngular.omb.ombapi.model.Account;

import java.util.List;
import java.util.Optional;

public interface AccountsService {

    List<Account> getAccounts() throws ExceptionFormat;

    Account postAccounts(Account account) throws ExceptionFormat;

    Optional<Account> getAccountsById(String accountId) throws ExceptionFormat;
}
