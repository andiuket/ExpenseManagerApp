package com.andrew.expensemanagerapp.controller;

import com.andrew.expensemanagerapp.request.ProfileRequest;
import com.andrew.expensemanagerapp.entity.User;
import com.andrew.expensemanagerapp.request.ProfileResponse;
import com.andrew.expensemanagerapp.service.ProfileService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {

    @Autowired
    private ProfileService profileService;

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
    @ResponseStatus(HttpStatus.CREATED)
    public ProfileResponse registerUser(@Valid @RequestBody ProfileRequest request){
        ProfileResponse profile = profileService.createProfile(request);
        return profile;
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody ProfileRequest userDto){
        return null;
    }

    @DeleteMapping("/{id}")
    public Integer deleteUser(@PathVariable Long id){
        return 0;
    }
}
