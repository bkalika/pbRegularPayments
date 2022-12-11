package com.pb.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * @author @bkalika
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceCardGenerator")
    @GenericGenerator(
            name = "sequenceCardGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "card_sequence"),
                    @Parameter(name = "initial_value", value = "0"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @Column(
            name = "number",
            unique = true,
            nullable = false,
            length = 16
    )
    private Long cardNumber;

    public Card() {
    }

    public Card(Long id, Client client, Long cardNumber) {
        this.id = id;
        this.client = client;
        this.cardNumber = cardNumber;
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

    public Long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
    }
}
