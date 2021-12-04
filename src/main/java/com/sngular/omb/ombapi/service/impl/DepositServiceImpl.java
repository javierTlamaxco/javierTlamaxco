package com.sngular.omb.ombapi.service.impl;

import com.sngular.omb.ombapi.exception.ExceptionFormat;
import com.sngular.omb.ombapi.model.Account;
import com.sngular.omb.ombapi.model.request.DepositRequest;
import com.sngular.omb.ombapi.model.response.DepositResponse;
import com.sngular.omb.ombapi.repository.AccountsRepository;
import com.sngular.omb.ombapi.service.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**Class implements interface DepositService*/
@Service
public class DepositServiceImpl  implements DepositService {
    /**Accounts Repository.*/
    @Autowired
    AccountsRepository accountsRepository;

    /**Account Deposit method service
     *
     * @param  accountId  account Id.
     * @param depositRequest depositRequest.
     * @throws ExceptionFormat if theres an Exception.
     *
     * @return DepositResponse.
     * */
   @Override
    public DepositResponse makeDeposit(String accountId, DepositRequest depositRequest) throws ExceptionFormat {
        Optional<Account> accountOptional = accountsRepository.findById(accountId);
        if (accountOptional.isPresent()) {
            Account account = accountOptional.get();
            account.setCurrentBalance(account.getCurrentBalance() + depositRequest.getAmount());
            accountsRepository.save(account);
           return new DepositResponse(account.getId(), account.getCurrentBalance());
        } else{
            return new DepositResponse("Account Not found", 0.0);
        }
    }
}
