package com.sngular.omb.ombapi.repository;

import com.sngular.omb.ombapi.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
/** Account repository interface*/
public interface AccountsRepository extends MongoRepository<Account, String> {
}

