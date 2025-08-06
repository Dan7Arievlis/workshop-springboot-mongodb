package com.danielsilveira.workshopmongo.post;

import com.danielsilveira.workshopmongo.common.util.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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

    @GetMapping(value = "fullsearch")
    public ResponseEntity<List<PostEntity>> fullSearch(@RequestParam(value = "text", defaultValue = "") String text,
                                                       @RequestParam(value = "from", defaultValue = "") String from,
                                                       @RequestParam(value = "to", defaultValue = "") String to) {
        text = URL.decodeParam(text);
        Date fromDate = URL.convertDate(from, new Date(0L));
        Date toDate = URL.convertDate(to, new Date());

        return ResponseEntity.ok().body(postService.fullSearch(text, fromDate, toDate));
    }
}
