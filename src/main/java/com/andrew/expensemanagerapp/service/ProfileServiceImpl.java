package com.andrew.expensemanagerapp.service;

import com.andrew.expensemanagerapp.entity.User;
import com.andrew.expensemanagerapp.repository.UserRepository;
import com.andrew.expensemanagerapp.request.ProfileRequest;
import com.andrew.expensemanagerapp.request.ProfileResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.UUID;

@Service
public class ProfileServiceImpl implements ProfileService{

    @Autowired
    private UserRepository userRepo;

    @Override
    public ProfileResponse createProfile(ProfileRequest request) {
        User newProfile = convertToUser(request);
        if(!userRepo.existsByEmail(request.getEmail())){
            newProfile = userRepo.save(newProfile);
            return convertToUserResponse(newProfile);
        }
        throw new ResponseStatusException(HttpStatus.CONFLICT,"");
    }

    private ProfileResponse convertToUserResponse(User newProfile) {
        return ProfileResponse.builder()
                .userId(newProfile.getUserId())
                .name(newProfile.getName())
                .email(newProfile.getEmail())
                .isAccountVerified(newProfile.isAccountVerified())
                .build();
    }

    private User convertToUser(ProfileRequest request) {
        return User.builder()
                .name(request.getName())
                .userId(UUID.randomUUID().toString())
                .email(request.getEmail())
                .password(request.getPassword())
                .isAccountVerified(false)
                .resetOtpExpireAt(0L)
                .verifyOtp(null)
                .verifyOtpExpireAt(0L)
                .resetOtp(null)
                .build();
    }


}
