package com.sngular.omb.ombapi.service;

import com.sngular.omb.ombapi.model.Account;

import java.util.List;
import java.util.Optional;

public interface AccountsService {

    List<Account> getAccounts();

    void postAccounts(Account account);

    Optional<Account> getAccountsById(String accountId);
}
