package com.danielsilveira.workshopmongo.post;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<PostEntity, String> {

    @Query("{ 'title' :  { $regex:  ?0, $options: 'i' } }")
    List<PostEntity> searchTitle(String text);

    List<PostEntity> findByTitleContainingIgnoreCase(String text);
}
