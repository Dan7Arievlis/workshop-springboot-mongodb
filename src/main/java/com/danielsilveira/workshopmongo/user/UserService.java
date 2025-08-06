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

    public void delete(String id){
        findById(id);
        userRepository.deleteById(id);
    }

    public UserEntity update(UserEntity user){
        UserEntity newUser = findById(user.getId());
        updateData(newUser, user);
        return userRepository.save(newUser);
    }

    private void updateData(UserEntity newUser, UserEntity user) {
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
    }

    public UserEntity fromDTO(UserDTO userDTO){
        return new UserEntity(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }
}
