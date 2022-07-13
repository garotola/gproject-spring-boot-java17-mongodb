package com.garotinho.gprojectmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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

    public List<Post> findByTitle(@PathVariable String text){
        return repository.searchTitle(text);
    }
}
