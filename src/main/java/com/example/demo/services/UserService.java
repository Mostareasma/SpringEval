package com.example.demo.services;

import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> search(String title) {
        return userRepository.findByNameContainsIgnoreCaseOrderById(title);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

}
