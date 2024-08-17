package io.chechi.taxi.service;

import io.chechi.taxi.dto.client.ClientRequest;
import io.chechi.taxi.dto.client.ClientUpdateRequest;
import io.chechi.taxi.dto.user.ClientResponse;
import io.chechi.taxi.dto.user.UserUpdatePasswordRequest;
import io.chechi.taxi.dto.user.UserUpdateRequest;

import java.util.List;

public interface ClientService {

    List<ClientResponse> findAllClients ();

    ClientResponse findClientById (Integer id);

    boolean existByEmail(String email);

    void deleteClientById (Integer id);

    ClientResponse createClient (ClientRequest request);

    ClientResponse updateClient (Integer id, ClientUpdateRequest request);

    void updateClientPassword (Integer id, UserUpdatePasswordRequest request);
}
