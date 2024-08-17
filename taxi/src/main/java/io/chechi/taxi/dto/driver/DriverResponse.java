package io.chechi.taxi.dto.driver;

import io.chechi.taxi.entity.RoleType;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DriverResponse {

    private int id;

    private String username;

    private String email;

    private String phoneNumber;

    private LocalDateTime createdAt;

    private Set<RoleType> roles;

    private String vehicleInfo;
}
