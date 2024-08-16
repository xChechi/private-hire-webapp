package io.chechi.taxi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "moderators")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class Moderator extends User {

}
