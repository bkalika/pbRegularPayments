package com.pb.mappers;

import com.pb.dto.PaymentDto;
import com.pb.entities.Payment;

/**
 * @author @bkalika
 */
public class PaymentMapper {
    public static Payment paymentDtoToPayment(PaymentDto paymentDto) {
        Payment payment = new Payment();
        payment.setId(paymentDto.getId());
        payment.setCard(CardMapper.cardDtoToCard(paymentDto.getCardDto()));
        payment.setReceiver(ReceiverMapper.receiverDtoToReceiver(paymentDto.getReceiverDto()));
        payment.setPeriod(paymentDto.getPeriod());
        payment.setAmount(paymentDto.getAmount());
        return payment;
    }

    public static PaymentDto paymentToPaymentDto(Payment payment) {
        PaymentDto paymentDto = new PaymentDto();
        paymentDto.setId(payment.getId());
        paymentDto.setCardDto(CardMapper.cardToCardDto(payment.getCard()));
        paymentDto.setReceiverDto(ReceiverMapper.receiverToReceiverDto(payment.getReceiver()));
        paymentDto.setPeriod(payment.getPeriod());
        paymentDto.setAmount(payment.getAmount());
        return paymentDto;
    }
}
