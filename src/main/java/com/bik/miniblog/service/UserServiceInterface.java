package com.bik.miniblog.service;

import com.bik.miniblog.dto.UserReqDto;
import com.bik.miniblog.dto.UserResDto;

import java.util.List;
import java.util.UUID;

public interface UserServiceInterface {
    List<UserResDto> getAllUsers();

    UserResDto createUser(UserReqDto user);

    UserResDto getUserById(UUID userId);

    void deleteUserById(UUID userId);

    UserResDto updateUser(UserReqDto user, UUID userId);
}
