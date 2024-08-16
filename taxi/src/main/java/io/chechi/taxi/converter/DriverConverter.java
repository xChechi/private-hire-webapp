package io.chechi.taxi.converter;

import io.chechi.taxi.dto.UserRequest;
import io.chechi.taxi.dto.UserResponse;
import io.chechi.taxi.entity.Driver;
import io.chechi.taxi.entity.Role;
import io.chechi.taxi.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Collections;

@Component
@AllArgsConstructor
public class DriverConverter implements EntityConverter<Driver, UserRequest, UserResponse> {

    private final ClientRepository clientRepository;

    @Override
    public Driver create (UserRequest request) {
        return Driver.builder()
                .username(request.getUsername())
                .password(request.getPassword()) // Ensure to handle password securely
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .createdAt(LocalDateTime.now())
                .roles(Collections.singleton(Role.CLIENT))
                .vehicleInfo(request.getVehicleInfo())
                .build();
    }

    @Override
    public UserResponse toResponse(Driver driver) {
        return UserResponse.builder()
                .id(driver.getId())
                .username(driver.getUsername())
                .email(driver.getEmail())
                .phoneNumber(driver.getPhoneNumber())
                .createdAt(driver.getCreatedAt())
                .roles(driver.getRoles())
                .vehicleInfo(driver.getVehicleInfo())
                .build();
    }
}

