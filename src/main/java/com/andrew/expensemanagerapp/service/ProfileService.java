package com.andrew.expensemanagerapp.service;

import com.andrew.expensemanagerapp.request.ProfileRequest;
import com.andrew.expensemanagerapp.request.ProfileResponse;

public interface ProfileService {
    ProfileResponse createProfile(ProfileRequest request);
}
