package io.chechi.taxi.init;

import io.chechi.taxi.dto.UserResponse;
import io.chechi.taxi.entity.Role;
import io.chechi.taxi.entity.User;
import io.chechi.taxi.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class UserAdminInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final AdminConfig adminConfig;

    @Override
    public void run(String... args) throws Exception {
        for (AdminConfig.AdminUserConfig adminUser : adminConfig.getUsers()) {
            if (userRepository.findByEmail(adminUser.getEmail()).isEmpty()) {
                User user = User.builder()
                        .username(adminUser.getUsername())
                        .password(adminUser.getPassword()) // Ensure this is encoded
                        .email(adminUser.getEmail())
                        .phoneNumber(adminUser.getPhoneNumber())
                        .role(Role.valueOf(adminUser.getRole()))
                        .createdAt(LocalDateTime.now())
                        .build();
                userRepository.save(user);
            }
        }
    }

}
