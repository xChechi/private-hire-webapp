package io.chechi.taxi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "drivers")
@Getter
@Setter
@SuperBuilder
public class Driver extends User {

    @NotBlank
    private String vehicleInfo;
}
