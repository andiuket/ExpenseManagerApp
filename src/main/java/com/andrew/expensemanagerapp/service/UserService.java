package com.andrew.expensemanagerapp.service;

import com.andrew.expensemanagerapp.io.UserRequest;
import com.andrew.expensemanagerapp.io.UserResponse;

public interface UserService {
    UserResponse registerUser(UserRequest request);
}
