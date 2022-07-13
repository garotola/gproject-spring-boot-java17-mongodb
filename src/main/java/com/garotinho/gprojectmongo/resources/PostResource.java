package com.garotinho.gprojectmongo.resources;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.garotinho.gprojectmongo.domain.Post;
import com.garotinho.gprojectmongo.resources.util.URL;
import com.garotinho.gprojectmongo.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired PostService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post post = service.findById(id);
        return ResponseEntity.ok().body(post);
    }

    @RequestMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "return ") String text){
        return ResponseEntity.ok().body(service.findByTitle(URL.decodeParam(text)));
    }
    
    @RequestMapping(value = "/fullsearch")
    public ResponseEntity<List<Post>> fullSearch(
        @RequestParam(value = "text", defaultValue = "") String text,
        @RequestParam(value = "minDate", defaultValue = "") String minDate,
        @RequestParam(value = "maxDate", defaultValue = "") String maxDate
    ){
        text = URL.decodeParam(text);
        Date min = URL.convertDate(minDate, new Date(0L));
        Date max = URL.convertDate(maxDate, new Date()); 
        List<Post> list = service.fullSearch(text, min, max);
        return ResponseEntity.ok().body(list);
    }
}
