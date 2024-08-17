package io.chechi.taxi.dto.driver;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DriverRequest {

    private String username;

    @NotBlank
    private String password;

    @Email
    private String email;

    @NotBlank
    private String phoneNumber;

    @NotBlank
    private String vehicleInfo;

}
