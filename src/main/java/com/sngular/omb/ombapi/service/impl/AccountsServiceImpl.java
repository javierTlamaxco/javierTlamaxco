package com.sngular.omb.ombapi.service.impl;

import com.sngular.omb.ombapi.model.Account;
import com.sngular.omb.ombapi.repository.AccountsRepository;
import com.sngular.omb.ombapi.service.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountsServiceImpl implements AccountsService {

    @Autowired
    AccountsRepository accountsRepository;

    @Override
    public List<Account> getAccounts() {

        if(!accountsRepository.findAll().isEmpty()){
            return accountsRepository.findAll();
        }
        return null;
    }

    @Override
    public void postAccounts(Account account) {

        accountsRepository.insert(account);
    }

    @Override
    public Optional<Account> getAccountsById(String accountId) {
        if(accountsRepository.findById(accountId).isEmpty()){
            return Optional.empty();
                    }   else {
            return accountsRepository.findById(accountId);
        }
    }
}
