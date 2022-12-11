package com.pb.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import org.hibernate.annotations.Parameter;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author @bkalika
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "client")
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceClientGenerator")
    @GenericGenerator(
            name = "sequenceClientGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "client_sequence"),
                    @Parameter(name = "initial_value", value = "1000"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    private Long id;

    @Column(name = "first_name", nullable = false)
    @Size(max = 100)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @Size(max = 100)
    private String lastName;

    @Column(
            name = "inn",
            nullable = false,
            unique = true,
            length = 10
    )
    private Long inn;

    public Client() {
        super();
    }

    public Client(Long id, String firstName, String lastName, Long inn) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.inn = inn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getInn() {
        return inn;
    }

    public void setInn(Long inn) {
        this.inn = inn;
    }
}
