package com.pb.dto;

import com.pb.entities.Client;
import com.pb.entities.Period;

import java.math.BigDecimal;

/**
 * @author @bkalika
 */
public class PaymentDto {
    private Long id;
    private Client sender;
    private Client receiver;
    private Period period;
    private BigDecimal amount;

    public PaymentDto() {
        super();
    }

    public PaymentDto(Long id, Client sender, Client receiver, Period period, BigDecimal amount) {
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
