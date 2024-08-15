package io.chechi.taxi.converter;

import io.chechi.taxi.dto.UserRequest;
import io.chechi.taxi.dto.UserResponse;
import io.chechi.taxi.entity.Role;
import io.chechi.taxi.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Collections;

@Component
@AllArgsConstructor
public class UserConverter {

    //private final PasswordEncoder passwordEncoder;

    public User createUser (UserRequest request) {

        return User.builder()
                .username(request.getUsername())
                .password(request.getPassword()) //<-- Don't forget to encode password in DB
                .email(request.getEmail())
                .roles(Collections.singleton(Role.CLIENT))
                .phoneNumber(request.getPhoneNumber())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public UserResponse toUserResponse (User user) {
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .createdAt(user.getCreatedAt())
                .roles(user.getRoles())
                .build();
    }


}
