package com.pb.dto;

import com.pb.entities.PaymentStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author @bkalika
 */
public class JournalDto {
    private Long id;
    private LocalDateTime time;
    private PaymentDto paymentDto;
    private BigDecimal amount;
    private PaymentStatus status;

    public JournalDto() {
    }

    public JournalDto(Long id, LocalDateTime time, PaymentDto paymentDto, BigDecimal amount, PaymentStatus status) {
        this.id = id;
        this.time = time;
        this.paymentDto = paymentDto;
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

    public PaymentDto getPaymentDto() {
        return paymentDto;
    }

    public void setPaymentDto(PaymentDto paymentDto) {
        this.paymentDto = paymentDto;
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
