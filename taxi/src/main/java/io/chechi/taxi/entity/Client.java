package io.chechi.taxi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "clients")
@Getter
@Setter
@SuperBuilder
public class Client extends User {
    // Additional fields specific to Client, if any

}
