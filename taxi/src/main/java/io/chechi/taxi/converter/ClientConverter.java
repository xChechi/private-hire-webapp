package io.chechi.taxi.converter;

import io.chechi.taxi.dto.client.ClientRequest;
import io.chechi.taxi.dto.client.ClientResponse;
import io.chechi.taxi.entity.Client;
import io.chechi.taxi.entity.RoleType;
import io.chechi.taxi.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@AllArgsConstructor
public class ClientConverter implements EntityConverter<Client, ClientRequest, ClientResponse> {

    private final ClientRepository clientRepository;



    @Override
    public Client create (ClientRequest request) {

        return Client.builder()
                .username(request.getUsername())
                .password(request.getPassword()) // Ensure to handle password securely
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
                .username(client.getUsername())
                .email(client.getEmail())
                .phoneNumber(client.getPhoneNumber())
                .createdAt(client.getCreatedAt())
                .role(client.getRole())
                .build();
    }
}
