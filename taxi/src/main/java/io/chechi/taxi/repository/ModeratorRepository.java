package io.chechi.taxi.repository;

import io.chechi.taxi.entity.Moderator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeratorRepository extends JpaRepository<Moderator, Integer> {
    boolean existsByEmail(String email);
}
