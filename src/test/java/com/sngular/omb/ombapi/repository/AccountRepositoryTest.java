package com.sngular.omb.ombapi.repository;

import com.sngular.omb.ombapi.model.Account;
import com.sngular.omb.ombapi.util.AccountType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;


@DataMongoTest(excludeAutoConfiguration = EmbeddedMongoAutoConfiguration.class)
public class AccountRepositoryTest {

    @Autowired
    private AccountsRepository accountsRepository;

   @BeforeEach
    void setUp(){
        Account account = new Account();
        account.setId("1");
        account.setName("Josua Smith Third");
        account.setAccountType(AccountType.checkingAccount);
        account.setDateBirth("1992-04-30");
        account.setInitialBalance(200.0);
        account.setRoutingNumber("12455554118");
        account.setAccountNumber("787878784484");

    }

    @AfterEach
            void cleanUp(){
           this.accountsRepository.deleteAll();
    }

    @Test
    void findAllAccounts(){

      Assertions.assertNotNull(accountsRepository.findAll());
    }

    @Test
    void findByIdAccount(){
       String findId = "1";

        Assertions.assertNotNull(accountsRepository.findById(findId));
    }

    @Test
    void postAccount(@Autowired MongoTemplate mongoTemplate){

        Account saveAccount = new Account();
        saveAccount.setId("2");
        saveAccount.setName("Josua Smith Third");
        saveAccount.setAccountType(AccountType.checkingAccount);
        saveAccount.setDateBirth("1992-04-30");
        saveAccount.setInitialBalance(200.0);
        saveAccount.setRoutingNumber("12455554118");
        saveAccount.setAccountNumber("787878784484");
        // when
        accountsRepository.save(saveAccount);

        Account account   =  mongoTemplate.findById("2", Account.class);
        // then
        Assertions.assertEquals("2",account.getId());
    }

}
