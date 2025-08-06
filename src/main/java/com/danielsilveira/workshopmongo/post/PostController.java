package com.danielsilveira.workshopmongo.post;

import com.danielsilveira.workshopmongo.common.util.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<PostEntity> findById(@PathVariable String id) {
        return ResponseEntity.ok().body(postService.findById(id));
    }

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<PostEntity>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParam(text);
        return ResponseEntity.ok().body(postService.findByTitle(text));
    }
}
