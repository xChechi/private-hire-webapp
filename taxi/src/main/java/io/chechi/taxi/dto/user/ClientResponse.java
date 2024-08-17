package io.chechi.taxi.dto.user;

import io.chechi.taxi.entity.RoleType;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ClientResponse {

    private int id;

    private String username;

    private String email;

    private String phoneNumber;

    private LocalDateTime createdAt;

    private RoleType role;

}
