package com.garotinho.gprojectmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.garotinho.gprojectmongo.domain.User;
import com.garotinho.gprojectmongo.repositories.UserRepository;

@Service
public class UserService {
    @Autowired UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }
}
