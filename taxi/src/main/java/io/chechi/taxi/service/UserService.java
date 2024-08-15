package io.chechi.taxi.service;

import io.chechi.taxi.dto.UserRequest;
import io.chechi.taxi.dto.UserResponse;
import io.chechi.taxi.dto.UserUpdatePasswordRequest;
import io.chechi.taxi.dto.UserUpdateRequest;

import java.util.List;

public interface UserService {

    List<UserResponse> findAllUsers ();

    UserResponse findUserById (Integer id);

    boolean existByEmail(String email);

    void deleteUserById (Integer id);

    UserResponse createUser (UserRequest request);

    UserResponse updateUser (Integer id, UserUpdateRequest request);

    void updateUserPassword (Integer id, UserUpdatePasswordRequest request);
}
