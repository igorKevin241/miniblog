package com.bik.miniblog.controller;

import com.bik.miniblog.dto.UserReqDto;
import com.bik.miniblog.dto.UserResDto;
import com.bik.miniblog.service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserServiceInterface userServiceInterface;

    public UserController(UserServiceInterface userServiceInterface) {
        this.userServiceInterface = userServiceInterface;
    }

    @GetMapping("/get-all-users")
    public List<UserResDto> getAllUsers() {

        return userServiceInterface.getAllUsers();
    }

    @PostMapping("/create-user")
    public UserResDto createUser(UserReqDto user) {

        return userServiceInterface.createUser(user);
    }
    @GetMapping("/get-user-by-id")
    public UserResDto getUserById(UUID userId) {
        return userServiceInterface.getUserById(userId);
    }

    @DeleteMapping("/delete-user-by-id")
    public void deleteUserById(UUID userId) {
        userServiceInterface.deleteUserById(userId);
    }

    @PutMapping("/update-user")
    public UserResDto updateUser(@RequestBody UserReqDto user, @PathVariable UUID userId) {

        return userServiceInterface.updateUser(user, userId);
    }
}
