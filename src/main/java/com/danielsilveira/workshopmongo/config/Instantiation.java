package com.danielsilveira.workshopmongo.config;

import com.danielsilveira.workshopmongo.post.AuthorDTO;
import com.danielsilveira.workshopmongo.post.PostEntity;
import com.danielsilveira.workshopmongo.post.PostRepository;
import com.danielsilveira.workshopmongo.user.UserEntity;
import com.danielsilveira.workshopmongo.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        postRepository.deleteAll();

        UserEntity maria = new UserEntity(null, "Maria Brown", "maria@gmail.com");
        UserEntity alex = new UserEntity(null, "Alex Green", "alex@gmail.com");
        UserEntity bob = new UserEntity(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(List.of(maria, alex, bob));

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        PostEntity post1 = new PostEntity(null, sdf.parse("21/03/2018"), "Partiu viagem!", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
        PostEntity post2 = new PostEntity(null, sdf.parse("23/03/2018"), "Acordei feliz hoje!", "Tenha um ótimo dia!", new AuthorDTO(maria));

        postRepository.saveAll(List.of(post1, post2));
    }
}
