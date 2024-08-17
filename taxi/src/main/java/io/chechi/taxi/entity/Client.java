package io.chechi.taxi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
//@Table(name = "clients")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
//@AllArgsConstructor
public class Client extends User {
    // Additional fields specific to Client, if any

}
