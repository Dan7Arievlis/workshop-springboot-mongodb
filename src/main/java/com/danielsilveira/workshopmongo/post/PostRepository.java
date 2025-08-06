package com.danielsilveira.workshopmongo.post;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<PostEntity, String> {
    List<PostEntity> findByTitleContainingIgnoreCase(String text);
}
