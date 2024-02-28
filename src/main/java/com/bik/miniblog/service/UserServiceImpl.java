package com.bik.miniblog.service;

import com.bik.miniblog.dto.UserReqDto;
import com.bik.miniblog.dto.UserResDto;
import com.bik.miniblog.entity.User;
import com.bik.miniblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserServiceInterface{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserResDto> getAllUsers() {

        List<User> users = userRepository.findAll();
        List<UserResDto> userResDtos = new ArrayList<>();

        for (User user : users) {
            userResDtos.add(new UserResDto().fromUser(user));
        }
        return userResDtos;
    }

    @Override
    public UserResDto createUser(UserReqDto user) {
        return new UserResDto().fromUser(userRepository.save(user.toUser()));
    }

    @Override
    public UserResDto getUserById(UUID userId) {
        return new UserResDto().fromUser(userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found !")));
    }

    @Override
    public void deleteUserById(UUID userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found !"));
        userRepository.deleteById(user.getUserId());
    }

    @Override
    public UserResDto updateUser(UserReqDto user, UUID userId) {
        User userUpdated = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found !"));
        userUpdated.setFirstname(user.getFirstname());
        userUpdated.setLastname(user.getLastname());
        userUpdated.setEmail(user.getEmail());
        userUpdated.setGenre(user.getGenre());
        userUpdated.setPassword(user.getPassword());
        userUpdated.setRole(user.getRole());
        userUpdated.setDatenaissance(user.getDatenaissance());



        return new UserResDto().fromUser(userRepository.save(userUpdated));
    }
}
