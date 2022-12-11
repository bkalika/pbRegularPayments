package com.pb.services;

import com.pb.dto.PaymentDto;

import java.util.List;

/**
 * @author @bkalika
 */
public interface IPaymentService {
    PaymentDto getPaymentById(Long id);
    PaymentDto addPayment(PaymentDto paymentDto);
    PaymentDto updatePayment(Long id, PaymentDto paymentDto);
    void deletePayment(Long id);

    List<PaymentDto> getPaymentsByInn(Long inn, Integer offset, Integer limit, String sortBy);

    List<PaymentDto> getPaymentsBySenderAccountOkpo(Long okpo, Integer offset, Integer limit, String orderBy);
}
