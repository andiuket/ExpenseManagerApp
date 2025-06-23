package com.andrew.expensemanagerapp.controller;

import com.andrew.expensemanagerapp.io.UserRequest;
import com.andrew.expensemanagerapp.io.UserResponse;
import com.andrew.expensemanagerapp.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @Value("${app.name: Expense Manager}")
    private String appName;

    @Value("${app.version: version 1.1}")
    private String appVersion;

    @GetMapping("/version")
    public String getAppDetails (){
        return appName + " - " + appVersion;
    }


    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse registerUser(@RequestBody UserRequest request){
        return userService.registerUser(request);
    }

}
