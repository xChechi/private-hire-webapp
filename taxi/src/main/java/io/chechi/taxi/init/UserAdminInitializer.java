package io.chechi.taxi.init;

import io.chechi.taxi.entity.Role;
import io.chechi.taxi.entity.User;
import io.chechi.taxi.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class UserAdminInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final AdminConfig adminConfig;

    @Override
    public void run(String... args) {
        initUsers();
    }

    private void initUsers() {
        adminConfig.getUsers().forEach(user -> {
            String username = user.getUsername();
            String email = user.getEmail();
            String password = user.getPassword();
            String phoneNumber = user.getPhoneNumber();
            List<String> roles = user.getRoles();

            if (userRepository.findByEmail(email).isEmpty()) {
                User newUser = new User();
                newUser.setUsername(username);
                newUser.setEmail(email);
                newUser.setPassword(password);
                newUser.setPhoneNumber(phoneNumber);
                newUser.setCreatedAt(LocalDateTime.now());
                newUser.setRoles(roles.stream().map(Role::valueOf).collect(Collectors.toSet()));
                userRepository.save(newUser);
            }
        });
    }

}
