package com.garotinho.gprojectmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.garotinho.gprojectmongo.domain.User;
import com.garotinho.gprojectmongo.dto.UserDTO;
import com.garotinho.gprojectmongo.repositories.UserRepository;
import com.garotinho.gprojectmongo.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {
    @Autowired UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(String id){
        Optional<User> user = repository.findById(id);        
        return user.orElseThrow(()-> new ObjectNotFoundException("Usuário não encontrado"));
    }

    public void delete(String id){
        repository.findById(id);
        repository.deleteById(id);
    }

    public User insert(User user){
        return repository.insert(user);
    }

    public User fromDTO(UserDTO userDTO){
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }
}
