package io.chechi.taxi.dto.client;

import io.chechi.taxi.dto.user.UserUpdatePasswordRequest;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
//@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ClientUpdatePasswordRequest extends UserUpdatePasswordRequest {

}
