package com.garotinho.gprojectmongo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.garotinho.gprojectmongo.domain.Post;
import com.garotinho.gprojectmongo.repositories.PostRepository;
import com.garotinho.gprojectmongo.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {
    @Autowired PostRepository repository;

    public Post findById(String id){
        Optional<Post> post = repository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Post não encontrado."));
    }

}
