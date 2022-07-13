package com.garotinho.gprojectmongo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.garotinho.gprojectmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

    @Query("{'title' : {$regex : ?0, $options : 'i'}}")
    List<Post> searchTitle(String text);
    List<Post> findByTitleContainingIgnoreCase(String text); // Query Method que procura um post com titulo que possui o texto especificado no parametro.
}
