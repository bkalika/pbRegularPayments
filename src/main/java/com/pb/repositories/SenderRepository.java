package com.pb.repositories;

import com.pb.entities.Sender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author @bkalika
 */
@Repository
public interface SenderRepository extends JpaRepository<Sender, Long> {
    Optional<Sender> findByInn(Long inn);
}
