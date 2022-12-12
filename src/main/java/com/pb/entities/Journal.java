package com.pb.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author @bkalika
 * Journal == Проводки
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "journal")
public class Journal implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceJournalGenerator")
    @GenericGenerator(
            name = "sequenceJournalGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "journal_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1000"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    private Long id;

    @Column(
            name = "time",
            updatable = false
    )
    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]"
    )
    @CreationTimestamp
    private LocalDateTime time;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id", nullable = false)
    private Payment payment;

    @Column(
            name = "amount",
            nullable = false
    )
    @ColumnDefault("0")
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(
            name = "status",
            nullable = false
    )
    @ColumnDefault("ACTIVE")
    private PaymentStatus status;

    public Journal() {
        super();
    }

    public Journal(Long id, LocalDateTime time, Payment payment, BigDecimal amount, PaymentStatus status) {
        this.id = id;
        this.time = time;
        this.payment = payment;
        this.amount = amount;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }
}
