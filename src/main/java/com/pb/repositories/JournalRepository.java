package com.pb.repositories;

import com.pb.entities.Journal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author @bkalika
 */
@Repository
public interface JournalRepository extends JpaRepository<Journal, Long> {
}
