package com.pb.repositories;

import com.pb.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author @bkalika
 */
@Repository
public interface ClientAccountRepository extends JpaRepository<Account, Long> {
}
