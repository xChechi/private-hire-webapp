package io.chechi.taxi.service.impl;

import io.chechi.taxi.converter.ClientConverter;

import io.chechi.taxi.dto.client.ClientRequest;
import io.chechi.taxi.dto.client.ClientUpdatePasswordRequest;
import io.chechi.taxi.dto.client.ClientUpdateRequest;
import io.chechi.taxi.dto.user.ClientResponse;
import io.chechi.taxi.dto.user.UserUpdatePasswordRequest;
import io.chechi.taxi.entity.Client;
import io.chechi.taxi.exception.DuplicateEmailException;
import io.chechi.taxi.exception.UserNotFoundException;
import io.chechi.taxi.repository.ClientRepository;

import io.chechi.taxi.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientConverter clientConverter;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<ClientResponse> findAllClients() {
        List<Client> clients = clientRepository.findAll();
        List<ClientResponse> responses = new ArrayList<>();

        for (Client c : clients) {
            ClientResponse response = clientConverter.toResponse(c);
            responses.add(response);
        }

        return responses;
    }

    @Override
    public ClientResponse findClientById(Integer id) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
        return clientConverter.toResponse(client);
    }

    @Override
    public boolean existByEmail(String email) {
        return clientRepository.existsByEmail(email);
    }

    @Override
    public void deleteClientById(Integer id) {
        clientRepository.deleteById(id);
    }

    @Override
    public ClientResponse createClient(ClientRequest request) {
        if (existByEmail(request.getEmail())) {
            throw new DuplicateEmailException("Email already exist");
        }

        Client client = clientConverter.create(request);
        Client savedClient = clientRepository.save(client);
        return clientConverter.toResponse(savedClient);
    }

    @Override
    public ClientResponse updateClient(Integer id, ClientUpdateRequest request) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));

        client.setName(request.getUsername());
        client.setPhoneNumber(request.getPhoneNumber());

        Client savedClient = clientRepository.save(client);
        return clientConverter.toResponse(savedClient);
    }

    @Override
    public void updateClientPassword(Integer id, ClientUpdatePasswordRequest request) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
        client.setPassword(passwordEncoder.encode(request.getPassword()));
        clientRepository.save(client);
    }
}
