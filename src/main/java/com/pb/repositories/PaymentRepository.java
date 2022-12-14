package com.pb.repositories;

import com.pb.entities.Payment;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author @bkalika
 */
@Repository
public interface PaymentRepository extends PagingAndSortingRepository<Payment, Long> {
    List<Payment> findAll();
    Optional<Payment> findById(Long id);
    List<Payment> findByCardOwnerInn(Long id, Pageable pageable);
    List<Payment> findByReceiverOkpo(Long id, Pageable pageable);
    Payment save(Payment payment);
    void delete(Payment payment);
}
