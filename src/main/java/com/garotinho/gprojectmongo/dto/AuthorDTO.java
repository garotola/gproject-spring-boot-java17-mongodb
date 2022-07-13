package com.garotinho.gprojectmongo.dto;

import java.io.Serializable;

import com.garotinho.gprojectmongo.domain.User;

public class AuthorDTO implements Serializable{
    private String id;
    private String name;

    public AuthorDTO(){}
    public AuthorDTO(User user){
        id = user.getId();
        name = user.getName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
