package com.pb.repositories;

import com.pb.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author @bkalika
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByInn(Long inn);
}
