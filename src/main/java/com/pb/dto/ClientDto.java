package com.pb.dto;

/**
 * @author @bkalika
 */
public class ClientDto {
    private Long id;
    private String firstName;
    private String lastName;
    private Long inn;

    public ClientDto() {
        super();
    }

    public ClientDto(Long id, String firstName, String lastName, Long inn) {
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
