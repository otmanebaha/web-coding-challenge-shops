package org.shops.dao;

import org.bson.types.ObjectId;
import org.shops.entities.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<Account, Integer>{
}
