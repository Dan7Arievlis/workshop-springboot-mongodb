package com.danielsilveira.workshopmongo.post;

import com.danielsilveira.workshopmongo.common.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public PostEntity findById(String id) {
        return postRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found!"));
    }

    public List<PostEntity> findByTitle(String text) {
        return postRepository.searchTitle(text);
    }

    public List<PostEntity> fullSearch(String text, Date from, Date to) {
        to = new Date(to.getTime() + (1000 * 60 * 60 * 24));
        return postRepository.fullSearch(text, from, to);
    }
}
