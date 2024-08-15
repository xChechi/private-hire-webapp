package io.chechi.taxi.init;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix = "admin")
public class AdminConfig {
    private List<AdminUserConfig> users;

    @Data
    public static class AdminUserConfig {

        private String username;
        private String password;
        private String email;
        private String phoneNumber;
        private List<String> roles;
    }
}
