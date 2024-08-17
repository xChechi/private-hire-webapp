package io.chechi.taxi.converter;

import io.chechi.taxi.dto.client.ClientRequest;
import io.chechi.taxi.dto.client.ClientResponse;
import io.chechi.taxi.entity.Client;
import io.chechi.taxi.entity.RoleType;
import io.chechi.taxi.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

@Component
@AllArgsConstructor
public class ClientConverter implements EntityConverter<Client, ClientRequest, ClientResponse> {

    private final PasswordEncoder passwordEncoder;

    @Override
    public Client create (ClientRequest request) {

        return Client.builder()
                .name(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword())) // Ensure to handle password securely
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .createdAt(LocalDateTime.now())
                .role(RoleType.CLIENT)
                .build();
    }

    @Override
    public ClientResponse toResponse(Client client) {

        return ClientResponse.builder()
                .id(client.getId())
                .username(client.getName())
                .email(client.getEmail())
                .phoneNumber(client.getPhoneNumber())
                .createdAt(client.getCreatedAt())
                .role(client.getRole())
                .build();
    }
}
