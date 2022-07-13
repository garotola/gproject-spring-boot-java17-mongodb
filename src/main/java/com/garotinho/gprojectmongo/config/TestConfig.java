package com.garotinho.gprojectmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.garotinho.gprojectmongo.domain.Post;
import com.garotinho.gprojectmongo.domain.User;
import com.garotinho.gprojectmongo.dto.AuthorDTO;
import com.garotinho.gprojectmongo.repositories.PostRepository;
import com.garotinho.gprojectmongo.repositories.UserRepository;

@Configuration
public class TestConfig implements CommandLineRunner{

    @Autowired UserRepository userRepository;
    @Autowired PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User u1 = new User(null, "Maria", "@gmail.com");
        User u2 = new User(null, "Rafael", "@gmail.com");
        User u3 = new User(null, "Bia", "@gmail.com");       

        userRepository.saveAll(Arrays.asList(u1,u2,u3));

        Post p1 = new Post(null, dateFormat.parse("21/03/2018"), "Partiu Viagem", "Vou viajar para São Paulo", new AuthorDTO(u2));
        Post p2 = new Post(null, dateFormat.parse("23/03/2018"), "Bom dia", "Acordei Feliz Hoje", new AuthorDTO(u2));

        postRepository.saveAll(Arrays.asList(p1,p2));
        u1.getPosts().addAll(Arrays.asList(p1,p2));
        userRepository.save(u1);

    }
    
}
