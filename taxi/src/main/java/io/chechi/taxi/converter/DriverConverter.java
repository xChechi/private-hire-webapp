package io.chechi.taxi.converter;

/*
@Component
@AllArgsConstructor
public class DriverConverter implements EntityConverter<Driver, DriverRequest, DriverResponse> {

    private final ClientRepository clientRepository;

    @Override
    public Driver create (DriverRequest request) {
        return Driver.builder()
                .username(request.getUsername())
                .password(request.getPassword()) // Ensure to handle password securely
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .createdAt(LocalDateTime.now())
                .roles(Collections.singleton(RoleType.CLIENT))
                .vehicleInfo(request.getVehicleInfo())
                .build();
    }

    @Override
    public DriverResponse toResponse(Driver driver) {
        return DriverResponse.builder()
                .id(driver.getId())
                .username(driver.getUsername())
                .email(driver.getEmail())
                .phoneNumber(driver.getPhoneNumber())
                .createdAt(driver.getCreatedAt())
                .roles(driver.getRoles())
                .vehicleInfo(driver.getVehicleInfo())
                .build();
    }
}

 */

