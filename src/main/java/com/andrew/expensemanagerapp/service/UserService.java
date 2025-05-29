package com.andrew.expensemanagerapp.service;

import com.andrew.expensemanagerapp.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
}
