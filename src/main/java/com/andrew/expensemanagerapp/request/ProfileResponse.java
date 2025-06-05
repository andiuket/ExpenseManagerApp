package com.andrew.expensemanagerapp.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
public class ProfileResponse {
    private String userId;
    private String name;
    private String email;
    private boolean isAccountVerified;
}
