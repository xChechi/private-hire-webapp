package io.chechi.taxi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vehicles")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

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

    @OneToOne(mappedBy = "vehicle")
    private Driver driver;
}
