package io.chechi.taxi.init;

import io.chechi.taxi.config.AdminProperties;
import io.chechi.taxi.entity.Admin;
import io.chechi.taxi.entity.Moderator;
import io.chechi.taxi.entity.Role;
import io.chechi.taxi.repository.AdminRepository;
import io.chechi.taxi.repository.ModeratorRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@AllArgsConstructor
public class AdminInitializer implements CommandLineRunner {

    private final AdminRepository adminRepository;
    private final ModeratorRepository moderatorRepository;
    private final AdminProperties adminProperties;
    //private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        adminProperties.getUsers().forEach(userConfig -> {
            if (userConfig.getRoles().contains(Role.ADMIN)) {
                if (!adminRepository.existsByEmail(userConfig.getEmail())) {
                    Admin admin = Admin.builder()
                            .username(userConfig.getUsername())
                            .password(userConfig.getPassword())
                            .email(userConfig.getEmail())
                            .phoneNumber(userConfig.getPhoneNumber())
                            .build();
                    // Save Admin before assigning roles
                    admin = adminRepository.save(admin);
                    admin.setRoles(Set.copyOf(userConfig.getRoles()));
                    adminRepository.save(admin);
                }
            } else if (userConfig.getRoles().contains(Role.MODERATOR)) {
                if (!moderatorRepository.existsByEmail(userConfig.getEmail())) {
                    Moderator moderator = Moderator.builder()
                            .username(userConfig.getUsername())
                            .password(userConfig.getPassword())
                            .email(userConfig.getEmail())
                            .phoneNumber(userConfig.getPhoneNumber())
                            .build();
                    // Save Moderator before assigning roles
                    moderator = moderatorRepository.save(moderator);
                    moderator.setRoles(Set.copyOf(userConfig.getRoles()));
                    moderatorRepository.save(moderator);
                }
            } else {
                throw new IllegalStateException("Unsupported role configuration");
            }
        });
    }
}
