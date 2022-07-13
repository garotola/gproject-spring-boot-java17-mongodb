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

    public User update(User user){
        Optional<User> optionalUserBD = repository.findById(user.getId());
        User userBD = optionalUserBD.get();
        updateData(user, userBD);
        return repository.save(userBD);
    }

    private void updateData(User user, User userBD) {
        userBD.setName(user.getName());
        userBD.setEmail(user.getEmail());
    }

    public User fromDTO(UserDTO userDTO){
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }
}
