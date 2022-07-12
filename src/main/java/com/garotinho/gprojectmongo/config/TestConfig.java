package com.garotinho.gprojectmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.garotinho.gprojectmongo.domain.User;
import com.garotinho.gprojectmongo.repositories.UserRepository;

@Configuration
public class TestConfig implements CommandLineRunner{

    @Autowired UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {        
        
        userRepository.deleteAll();

        User u1 = new User(null, "Maria", "@gmail.com");
        User u2 = new User(null, "Rafael", "@gmail.com");
        User u3 = new User(null, "Bia", "@gmail.com");       

        userRepository.saveAll(Arrays.asList(u1,u2,u3));

    }
    
}
