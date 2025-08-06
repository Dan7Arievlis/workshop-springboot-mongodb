package com.danielsilveira.workshopmongo.user;

import com.danielsilveira.workshopmongo.common.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> findAll(){
        return userRepository.findAll();
    }

    public UserEntity findById(String id){
        return userRepository.findById(id).orElseThrow(()->new ObjectNotFoundException("User not found"));
    }

    public UserEntity insert(UserEntity user){
        return userRepository.insert(user);
    }

    public UserEntity fromDTO(UserDTO userDTO){
        return new UserEntity(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }
}
