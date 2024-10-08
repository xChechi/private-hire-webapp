package io.chechi.taxi.config;

import io.chechi.taxi.entity.RoleType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Set;

@Configuration
@ConfigurationProperties(prefix = "admin")
@Getter
@Setter
public class AdminProperties {
    private List<UserConfig> users;

    @Getter
    @Setter
    public static class UserConfig {
        private String username;
        private String password;
        private String email;
        private String phoneNumber;

    }
}
