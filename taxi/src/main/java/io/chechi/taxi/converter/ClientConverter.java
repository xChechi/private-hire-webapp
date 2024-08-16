package io.chechi.taxi.converter;

import io.chechi.taxi.dto.UserRequest;
import io.chechi.taxi.dto.UserResponse;
import io.chechi.taxi.entity.Client;
import io.chechi.taxi.entity.Role;
import io.chechi.taxi.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Collections;

@Component
@AllArgsConstructor
public class ClientConverter implements EntityConverter<Client, UserRequest, UserResponse> {

    private final ClientRepository clientRepository;

    @Override
    public Client create (UserRequest request) {
        return Client.builder()
                .username(request.getUsername())
                .password(request.getPassword()) // Ensure to handle password securely
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .createdAt(LocalDateTime.now())
                .roles(Collections.singleton(Role.CLIENT))
                .build();
    }

    @Override
    public UserResponse toResponse(Client client) {
        return UserResponse.builder()
                .id(client.getId())
                .username(client.getUsername())
                .email(client.getEmail())
                .phoneNumber(client.getPhoneNumber())
                .createdAt(client.getCreatedAt())
                .roles(client.getRoles())
                .build();
    }
}
