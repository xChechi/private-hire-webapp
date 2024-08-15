package io.chechi.taxi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserUpdateRequest {

    @NotBlank
    private String username;

    @Email
    private String email;

    @NotBlank
    private String phoneNumber;
}
