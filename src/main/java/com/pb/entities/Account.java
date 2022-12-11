package com.pb.entities;


import jakarta.persistence.*;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;

/**
 * @author @bkalika
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "account")
public class Account implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceAccountGenerator")
    @GenericGenerator(
            name = "sequenceAccountGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "account_sequence"),
                    @Parameter(name = "initial_value", value = "1000"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @Column(
            name = "account_number",
            unique = true
    )
    private Long accountNumber;



    public Account() {
        super();
    }

    public Account(Long id, Client client, Long accountNumber, Long cardNumber, Long mfo, Long okpo) {
        this.id = id;
        this.client = client;
        this.accountNumber = accountNumber;
        this.cardNumber = cardNumber;
        this.mfo = mfo;
        this.okpo = okpo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Long getMfo() {
        return mfo;
    }

    public void setMfo(Long mfo) {
        this.mfo = mfo;
    }

    public Long getOkpo() {
        return okpo;
    }

    public void setOkpo(Long okpo) {
        this.okpo = okpo;
    }
}
