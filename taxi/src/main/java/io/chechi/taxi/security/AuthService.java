package io.chechi.taxi.security;

import io.chechi.taxi.dto.user.ClientRequest;
import io.chechi.taxi.dto.security.AuthResponse;
import io.chechi.taxi.dto.security.LoginRequest;
import io.chechi.taxi.exception.UserNotFoundException;
import io.chechi.taxi.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
/*
@Service
@AllArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;
    private final JwtService jwtService;
    private final AuthenticationManager manager;

    public AuthResponse registerClient (ClientRequest request) {

        var user = userConverter.createUser(request);

        userRepository.save(user);

        var jwtToken = jwtService.generateToken(user);

        return AuthResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthResponse login (LoginRequest request) {

        manager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        var user = userRepository.findByEmail(request.getEmail()).orElseThrow(() -> new UserNotFoundException("User not found"));
        var jwtToken = jwtService.generateToken(user);

        return AuthResponse.builder()
                .token(jwtToken)
                .build();
    }
}

 */
