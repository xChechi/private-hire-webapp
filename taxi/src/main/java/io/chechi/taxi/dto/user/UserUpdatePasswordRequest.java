package io.chechi.taxi.dto.user;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserUpdatePasswordRequest {

    @NotBlank
    private String password;
}
