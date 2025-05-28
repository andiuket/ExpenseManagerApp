package com.andrew.expensemanagerapp.controller;

import com.andrew.expensemanagerapp.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {


    @Value("${app.name: Expense Manager}")
    private String appName;

    @Value("${app.version: version 1.1}")
    private String appVersion;

    @GetMapping("/version")
    public String getAppDetails (){
        return appName + " - " + appVersion;
    }


    @GetMapping
    public User getUser(){
        return null;
    }

    @PostMapping("/register")
    public String registerUser(@Validated @RequestBody User user){
        return "";
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user){
        return null;
    }

    @DeleteMapping("/{id}")
    public Integer deleteUser(@PathVariable Long id){
        return 0;
    }
}
