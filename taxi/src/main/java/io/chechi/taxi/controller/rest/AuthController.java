package io.chechi.taxi.controller.rest;

import io.chechi.taxi.dto.client.ClientRequest;
import io.chechi.taxi.dto.security.AuthResponse;
import io.chechi.taxi.dto.security.LoginRequest;
import io.chechi.taxi.security.AuthenticationService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/clients/register")
    public ResponseEntity<AuthResponse> registerClient (@Valid @RequestBody ClientRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authenticationService.registerClient(request));
    }

    @PostMapping("/clients/login")
    public ResponseEntity<AuthResponse> loginUser (@Valid @RequestBody LoginRequest request) {

        return ResponseEntity.status(HttpStatus.OK).body(authenticationService.loginClient(request));
    }
}
