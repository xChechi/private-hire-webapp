package io.chechi.taxi.dto.vehicle;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VehicleRequest {

    @NotBlank
    private String make;

    @NotBlank
    private String model;

    @NotBlank
    private String year;

    @NotBlank
    private String color;

    @NotBlank
    private String plate;
}
