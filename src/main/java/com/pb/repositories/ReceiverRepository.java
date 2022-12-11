package com.pb.repositories;

import com.pb.entities.Receiver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author @bkalika
 */
@Repository
public interface ReceiverRepository extends JpaRepository<Receiver, Long> {
    Optional<Receiver> findByIban(String iban);
}
