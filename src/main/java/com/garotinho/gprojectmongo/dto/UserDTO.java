package com.garotinho.gprojectmongo.dto;

import java.io.Serializable;

import com.garotinho.gprojectmongo.domain.User;

public class UserDTO implements Serializable{
    
    private String id;
    private String name;
    private String email;

    public UserDTO(){}
    public UserDTO(User user){
        this.name = user.getName();
        this.id = user.getId();
        this.email = user.getEmail();
    }
    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
    

}
