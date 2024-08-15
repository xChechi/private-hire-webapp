package io.chechi.taxi.service.impl;

import io.chechi.taxi.converter.UserConverter;
import io.chechi.taxi.dto.UserRequest;
import io.chechi.taxi.dto.UserResponse;
import io.chechi.taxi.dto.UserUpdatePasswordRequest;
import io.chechi.taxi.dto.UserUpdateRequest;
import io.chechi.taxi.entity.User;
import io.chechi.taxi.exception.DuplicateEmailException;
import io.chechi.taxi.exception.UserNotFoundException;
import io.chechi.taxi.repository.UserRepository;
import io.chechi.taxi.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;

    @Override
    public List<UserResponse> findAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserResponse> responses = new ArrayList<>();

        for (User u : users) {
            UserResponse response = userConverter.toUserResponse(u);
            responses.add(response);
        }

        return responses;
    }

    @Override
    public UserResponse findUserById(Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
        return userConverter.toUserResponse(user);
    }

    @Override
    public boolean existByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public void deleteUserById(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserResponse createUser(UserRequest request) {
        if (existByEmail(request.getEmail())) {
            throw new DuplicateEmailException("Email already exist");
        }

        User user = userConverter.createUser(request);
        User savedUser = userRepository.save(user);
        return userConverter.toUserResponse(savedUser);
    }

    @Override
    public UserResponse updateUser(Integer id, UserUpdateRequest request) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));

        user.setUsername(request.getUsername());

        if (!existByEmail(request.getEmail())) {
            user.setEmail(request.getEmail());
        } else throw new DuplicateEmailException("Email already exist");

        user.setPhoneNumber(request.getPhoneNumber());
        User savedUser = userRepository.save(user);
        return userConverter.toUserResponse(savedUser);
    }

    @Override
    public UserResponse updateUserPassword(Integer id, UserUpdatePasswordRequest request) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
        user.setPassword(request.getPassword());
        User savedUser = userRepository.save(user);
        return userConverter.toUserResponse(savedUser);
    }
}
