package com.gemini.foms.service;

import com.gemini.foms.entity.User;
import com.gemini.foms.entity.enums.user.Role;
import com.gemini.foms.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public void saveUser(@RequestBody User user){
        userRepository.save(user);
    }

    public List<User> staffList(){

        return userRepository.findAll();
    }

    public Optional<User> getStaffById(@RequestBody Integer id){
        return userRepository.findById(id);
    }

    public List<User> getStaffByRole(@RequestBody Role role){
        return userRepository.getUserByRole(role);
    }


}
