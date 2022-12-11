package com.pb.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author @bkalika
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "payment")
public class Payment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequencePaymentGenerator")
    @GenericGenerator(
            name = "sequencePaymentGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "payment_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1000"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "card_id", nullable = false)
    private Account card_id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "receiver_account_id", nullable = false)
    private Account receiverAccount;

    @Column(
            name = "period",
            nullable = false
    )
    @Enumerated(EnumType.STRING)
    private Period period;

    @Column(
            name = "amount",
            nullable = false
    )
    @ColumnDefault("0")
    private BigDecimal amount;

    public Payment() {
        super();
    }

    public Payment(Long id, Client sender, Client receiver, Period period, BigDecimal amount) {
        this.id = id;
        this.sender = sender;
        this.receiver = receiver;
        this.period = period;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getSender() {
        return sender;
    }

    public void setSender(Client sender) {
        this.sender = sender;
    }

    public Client getReceiver() {
        return receiver;
    }

    public void setReceiver(Client receiver) {
        this.receiver = receiver;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
