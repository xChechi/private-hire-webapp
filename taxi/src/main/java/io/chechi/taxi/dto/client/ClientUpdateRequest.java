package io.chechi.taxi.dto.client;

import io.chechi.taxi.dto.user.UserUpdateRequest;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
//@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ClientUpdateRequest extends UserUpdateRequest {
}
