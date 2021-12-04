package com.sngular.omb.ombapi.service.impl;

import com.sngular.omb.ombapi.exception.ExceptionFormat;
import com.sngular.omb.ombapi.model.Account;
import com.sngular.omb.ombapi.repository.AccountsRepository;
import com.sngular.omb.ombapi.service.AccountsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class AccountsServiceImpl implements AccountsService {

    @Autowired
    AccountsRepository accountsRepository;

    @Override
    public List<Account> getAccounts()  throws ExceptionFormat {

        if(!accountsRepository.findAll().isEmpty()){
            return accountsRepository.findAll();
        }
        return null;
    }

    @Override
    public Account postAccounts(Account account) throws ExceptionFormat {
    try{
        account.setCurrentBalance(account.getInitialBalance());
       return  accountsRepository.insert(account);
    } catch (Exception exp){
        log.error("Can't create ");
        throw new ExceptionFormat(400,"Exception creating account"+exp);
    }

    }

    @Override
    public Optional<Account> getAccountsById(String accountId) throws ExceptionFormat {

        try {
            if(accountsRepository.findById(accountId).isEmpty()){
                return Optional.empty();
            }   else {
                return accountsRepository.findById(accountId);
            }
        } catch (Exception exp){
            log.error("Account not found"+accountId);
            throw new ExceptionFormat(400,"Not Found Account"+exp);
        }

    }
}
