package io.chechi.taxi.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class UserUpdateRequest {

    @NotBlank
    private String username;

    @NotBlank
    private String phoneNumber;
}
