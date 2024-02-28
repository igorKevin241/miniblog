package com.bik.miniblog.dto;

import com.bik.miniblog.entity.User;
import com.bik.miniblog.enums.Genre;
import com.bik.miniblog.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserReqDto {
    private String firstname;
    private String lastname;
    private String email;
    private UserRole role;
    private String password;
    private LocalDate datenaissance;
    private Genre genre;


    public User toUser() {
        return User.builder()
                .firstname(firstname)
                .lastname(lastname)
                .email(email)
                .role(role)
                .password(password)
                .datenaissance(datenaissance)
                .genre(genre)
                .build();
    }
}
