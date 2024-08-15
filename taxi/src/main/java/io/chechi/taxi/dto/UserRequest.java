package io.chechi.taxi.dto;

import io.chechi.taxi.entity.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {

    private String username;

    @NotBlank
    private String password;

    @Email
    private String email;

    @NotBlank
    private String phoneNumber;

    private LocalDateTime createdAt;

    private Role role;
}
