package com.garotinho.gprojectmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.garotinho.gprojectmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
    
}
