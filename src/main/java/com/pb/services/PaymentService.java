package com.pb.services;

import com.pb.dto.PaymentDto;
import com.pb.entities.Client;
import com.pb.entities.Payment;
import com.pb.exceptions.*;
import com.pb.mappers.PaymentMapper;
import com.pb.repositories.ClientRepository;
import com.pb.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author @bkalika
 */
@Service
public class PaymentService implements IPaymentService {
    private final PaymentRepository paymentRepository;
    private final ClientRepository clientRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository, ClientRepository clientRepository) {
        this.paymentRepository = paymentRepository;
        this.clientRepository = clientRepository;
    }

    public PaymentDto getPaymentById(Long id) {
        Payment optionalPayment = paymentRepository.findById(id).orElseThrow(
                () -> new PaymentException("No payment present with id " + id, HttpStatus.NOT_FOUND)
        );
        return PaymentMapper.paymentToPaymentDto(optionalPayment);
    }

    @Override
    public PaymentDto addPayment(PaymentDto paymentDto) {
        Client sender = validateClient(paymentDto.getSender());
        Client receiver = validateClient(paymentDto.getReceiver());

        Payment payment = new Payment();
        payment.setAmount(paymentDto.getAmount());
        payment.setPeriod(paymentDto.getPeriod());
        payment.setSender(sender);
        payment.setReceiver(receiver);

        Payment savedPayment = paymentRepository.save(payment);
        return PaymentMapper.paymentToPaymentDto(savedPayment);
    }

    @Override
    public PaymentDto updatePayment(Long id, PaymentDto paymentDto) {
        Payment payment = PaymentMapper.paymentDtoToPayment(getPaymentById(id));
        Client sender = validateClient(paymentDto.getSender());
        Client receiver = validateClient(paymentDto.getReceiver());
        payment.setSender(sender);
        payment.setReceiver(receiver);
        payment.setAmount(paymentDto.getAmount());
        payment.setPeriod(paymentDto.getPeriod());
        Payment updatedPayment = paymentRepository.save(payment);
        return PaymentMapper.paymentToPaymentDto(updatedPayment);
    }

    @Override
    public void deletePayment(Long id) {
        paymentRepository.delete(PaymentMapper.paymentDtoToPayment(getPaymentById(id)));
    }

    @Override
    public List<PaymentDto> getPaymentsByInn(Long inn, Integer offset, Integer limit, String orderBy) {
        Pageable paging = PageRequest.of(offset, limit, Sort.by(orderBy).descending());
        List<Payment> paymentsByInn = paymentRepository.findBySenderInn(inn, paging);
        return paymentsByInn.stream()
                .map(PaymentMapper::paymentToPaymentDto).toList();
    }

    @Override
    public List<PaymentDto> getPaymentsBySenderAccountOkpo(Long okpo, Integer offset, Integer limit, String orderBy) {
        Pageable paging = PageRequest.of(offset, limit, Sort.by(orderBy).descending());
        List<Payment> paymentsBySenderAccountIkpo = paymentRepository.findBySenderAccountOpko(okpo, paging);
        return null;
    }

    private Client getClientByInn(Client client) {
        return clientRepository.findByInn(client.getInn())
                .orElseThrow(() -> new ClientException(
                        String.format("Client with inn %s not found",
                                client.getInn()), HttpStatus.NOT_FOUND));
    }

    private Client validateClient(Client client) {
        Client optionalClient;
        try {
            optionalClient = getClientByInn(client);
        } catch (ApplicationException e) {
            optionalClient = clientRepository.save(client);
        }
        return optionalClient;
    }
}
