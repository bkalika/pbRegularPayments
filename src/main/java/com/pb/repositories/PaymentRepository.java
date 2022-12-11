package com.pb.repositories;

import com.pb.entities.Payment;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author @bkalika
 */
@Repository
public interface PaymentRepository extends PagingAndSortingRepository<Payment, Long> {
    Optional<Payment> findById(Long id);
    List<Payment> findBySenderInn(Long id, Pageable pageable);
    List<Payment> findBySenderAccountOpko(Long id, Pageable pageable);
    Payment save(Payment payment);
    void delete(Payment payment);
}
