package io.chechi.taxi.init;

import io.chechi.taxi.entity.Admin;
import io.chechi.taxi.entity.RoleType;
import io.chechi.taxi.entity.User;
import io.chechi.taxi.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class DatabaseSeeder {


    private UserRepository userRepository;
    private AdminConfig adminConfig;

    @PostConstruct
    public void seedDatabase() {
        List<Admin> admins = adminConfig.getUsers().stream()
                .map(userConfig -> {
                    // Check if the user already exists by username or email
                    Optional<User> existingAdmin = userRepository.findByEmail(userConfig.getEmail());
                    if (existingAdmin.isPresent()) {
                        return null; // Skip if user already exists
                    }

                    return Admin.builder()
                            .username(userConfig.getUsername())
                            .password(userConfig.getPassword())
                            .email(userConfig.getEmail())
                            .phoneNumber(userConfig.getPhoneNumber())
                            .createdAt(LocalDateTime.now())
                            .role(RoleType.valueOf(userConfig.getRoles().getFirst()))
                            .build();
                })
                .filter(Objects::nonNull) // Remove null entries
                .collect(Collectors.toList());

        if (!admins.isEmpty()) {
            userRepository.saveAll(admins);
        }
    }
}
