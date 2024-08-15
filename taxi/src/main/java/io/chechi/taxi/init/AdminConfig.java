package io.chechi.taxi.init;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Data
@Configuration
@ConfigurationProperties(prefix = "admin")
public class AdminConfig {
    private List<AdminUserConfig> users;

    @Data
    public static class AdminUserConfig {
        private String username;
        private String password;
        private String email;
        private String phoneNumber;
        private String role;
    }
}
