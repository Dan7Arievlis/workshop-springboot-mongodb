package com.danielsilveira.workshopmongo.config;

import com.danielsilveira.workshopmongo.user.UserEntity;
import com.danielsilveira.workshopmongo.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();

        UserEntity maria = new UserEntity(null, "Maria Brown", "maria@gmail.com");
        UserEntity alex = new UserEntity(null, "Alex Green", "alex@gmail.com");
        UserEntity bob = new UserEntity(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(List.of(maria, alex, bob));
    }
}
