package com.pb.repositories;

import com.pb.entities.Journal;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author @bkalika
 */
@Repository
public interface JournalRepository extends PagingAndSortingRepository<Journal, Long> {
    List<Journal> findAll();
    Optional<Journal> findById(Long id);
    Journal save(Journal journal);
    void delete(Journal journal);
    List<Journal> findByPaymentId(Long id, Pageable pageable);
}
