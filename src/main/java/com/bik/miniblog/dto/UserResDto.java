package com.bik.miniblog.dto;

import com.bik.miniblog.enums.UserRole;
import com.bik.miniblog.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResDto {
    private String firstname;
    private String lastname;
    private String email;
    private UserRole role;

    public UserResDto fromUser(User user) {
        return UserResDto.builder()
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }
}
