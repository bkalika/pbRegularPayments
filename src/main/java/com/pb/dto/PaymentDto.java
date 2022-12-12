package com.pb.dto;

import com.pb.entities.Period;

import java.math.BigDecimal;

/**
 * @author @bkalika
 */
public class PaymentDto {
    private Long id;
    private CardDto cardDto;
    private ReceiverDto receiverDto;
    private Period period;
    private BigDecimal amount;

    public PaymentDto() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CardDto getCardDto() {
        return cardDto;
    }

    public void setCardDto(CardDto cardDto) {
        this.cardDto = cardDto;
    }

    public ReceiverDto getReceiverDto() {
        return receiverDto;
    }

    public void setReceiverDto(ReceiverDto receiverDto) {
        this.receiverDto = receiverDto;
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
