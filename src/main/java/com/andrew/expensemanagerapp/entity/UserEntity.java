package com.andrew.expensemanagerapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.sql.Timestamp;



@Entity
@Table(name = "tbl_user")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
//    private String verifyOtp;
//    private boolean isAccountVerified;
//    private Long verifyOtpExpireAt;
//    private String resetOtp;
//    private Long resetOtpExpireAt;
//    @CreationTimestamp
//    @Column(
//            name = "created_at",
//            nullable = false,
//            updatable = false
//    )
//    private Timestamp createdAt;
//    @UpdateTimestamp
//    @Column(name = "updated_at")
//    private Timestamp updatedAt;
}
