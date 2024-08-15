package io.chechi.taxi.dto;

import io.chechi.taxi.entity.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {

    private String username;

    private String email;

    private String phoneNumber;

    private LocalDateTime createdAt;

    private Role role;
}
