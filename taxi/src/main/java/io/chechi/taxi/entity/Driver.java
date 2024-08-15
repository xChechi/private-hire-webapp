package io.chechi.taxi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "drivers")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    private String vehicleModel;

    @NotBlank
    private String vehicleColor;

    @NotBlank
    private String vehiclePlate;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
