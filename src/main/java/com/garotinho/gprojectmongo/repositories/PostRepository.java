package com.garotinho.gprojectmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.garotinho.gprojectmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
    
}
