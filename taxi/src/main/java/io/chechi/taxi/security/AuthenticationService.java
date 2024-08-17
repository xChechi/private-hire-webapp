package io.chechi.taxi.security;

import io.chechi.taxi.converter.ClientConverter;
import io.chechi.taxi.dto.client.ClientRequest;
import io.chechi.taxi.dto.security.AuthResponse;
import io.chechi.taxi.dto.security.LoginRequest;
import io.chechi.taxi.exception.UserNotFoundException;
import io.chechi.taxi.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final ClientConverter clientConverter;
    private final JwtService jwtService;
    private final AuthenticationManager manager;

    public AuthResponse registerClient (ClientRequest request) {

        var client = clientConverter.create(request);

        userRepository.save(client);

        var jwtToken = jwtService.generateToken(client);

        return AuthResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthResponse loginClient (LoginRequest request) {

        manager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        var user = userRepository.findByEmail(request.getEmail()).orElseThrow(() -> new UserNotFoundException("User not found"));
        var jwtToken = jwtService.generateToken(user);

        return AuthResponse.builder()
                .token(jwtToken)
                .build();
    }
}
