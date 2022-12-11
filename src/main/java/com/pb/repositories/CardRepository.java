package com.pb.repositories;

import com.pb.entities.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author @bkalika
 */
@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    Optional<Card> findByNumber(Long number);
}
