package com.pb.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author @bkalika
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "receiver")
public class Receiver implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceReceiverGenerator")
    @GenericGenerator(
            name = "sequenceReceiverGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "receiver_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "0"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    private Long id;

    @Column(
            name = "iban",
            nullable = false,
            length =29
    )
    private String iban;

    @Column(
            name = "mfo",
            length = 6
    )
    private Long mfo;

    @Column(name = "okpo", length = 6)
    private Long okpo;

    @Column(name = "name", nullable = false)
    @Size(max = 100)
    private String name;
    public Receiver() {
    }

    public Receiver(Long id, String iban, Long mfo, Long okpo, String name) {
        this.id = id;
        this.iban = iban;
        this.mfo = mfo;
        this.okpo = okpo;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
