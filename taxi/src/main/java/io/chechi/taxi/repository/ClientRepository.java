package io.chechi.taxi.repository;

import io.chechi.taxi.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    // Add client-specific queries if needed
}
