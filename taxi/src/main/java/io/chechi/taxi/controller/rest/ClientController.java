package io.chechi.taxi.controller.rest;

import io.chechi.taxi.dto.client.ClientRequest;
import io.chechi.taxi.dto.client.ClientUpdateRequest;
import io.chechi.taxi.dto.user.ClientResponse;
import io.chechi.taxi.dto.user.UserUpdatePasswordRequest;
import io.chechi.taxi.dto.user.UserUpdateRequest;
import io.chechi.taxi.service.ClientService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    @GetMapping
    public ResponseEntity<List<ClientResponse>> getAllClients () {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findAllClients());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponse> getClientById (@PathVariable Integer id) {
        ClientResponse response = clientService.findClientById(id);
        if (response != null) {
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping
    public ResponseEntity<ClientResponse> createClient (@RequestBody @Valid ClientRequest request) {
        ClientResponse createdClient = clientService.createClient(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdClient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClientById (@PathVariable Integer id) {
        ClientResponse client = clientService.findClientById(id);
        if (client == null) {
            return ResponseEntity.status(HttpStatus.OK).body("User not exist");
        } else {
            clientService.deleteClientById(id);
            return ResponseEntity.status(HttpStatus.OK).body("User deleted successfully");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientResponse> updateClient (@PathVariable Integer id, @RequestBody @Valid ClientUpdateRequest request) {
        ClientResponse updatedClient = clientService.updateClient(id, request);
        return ResponseEntity.status(HttpStatus.OK).body(updatedClient);
    }

    @PutMapping("/{id}/password")
    public ResponseEntity<String> updateClientPassword (@PathVariable Integer id, @RequestBody @Valid UserUpdatePasswordRequest request) {
        clientService.updateClientPassword(id, request);
        return ResponseEntity.status(HttpStatus.OK).body("Password changed successfully");
    }
}
