package com.garotinho.gprojectmongo.resources;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.garotinho.gprojectmongo.domain.User;
import com.garotinho.gprojectmongo.dto.UserDTO;
import com.garotinho.gprojectmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired UserService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> userList = service.findAll();
        List<UserDTO> userDtoList = userList.stream().map(user -> new UserDTO(user)).collect(Collectors.toList());
        return ResponseEntity.ok().body(userDtoList);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> findById(@PathVariable String id){
        User user = service.findById(id);
        UserDTO userDTO = new UserDTO(user);
        return ResponseEntity.ok().body(userDTO);
    }
}
