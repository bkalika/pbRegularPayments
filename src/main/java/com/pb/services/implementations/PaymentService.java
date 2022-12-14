package com.pb.services.implementations;

import com.pb.dto.PaymentDto;
import com.pb.entities.Card;
import com.pb.entities.Receiver;
import com.pb.entities.Payment;
import com.pb.entities.Sender;
import com.pb.exceptions.*;
import com.pb.mappers.CardMapper;
import com.pb.mappers.PaymentMapper;
import com.pb.mappers.ReceiverMapper;
import com.pb.repositories.PaymentRepository;
import com.pb.services.ICardService;
import com.pb.services.IPaymentService;
import com.pb.services.IReceiverService;
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

    private final ICardService cardService;
    private final IReceiverService receiverService;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository,
                          ICardService cardService,
                          IReceiverService receiverService) {
        this.paymentRepository = paymentRepository;
        this.cardService = cardService;
        this.receiverService = receiverService;
    }

    @Override
    public List<PaymentDto> getPayments() {
        List<Payment> payments = paymentRepository.findAll();
        return payments.stream().map(PaymentMapper::paymentToPaymentDto).toList();
    }

    @Override
    public PaymentDto getPaymentById(Long id) {
        Payment optionalPayment = paymentRepository.findById(id).orElseThrow(
                () -> new PaymentException("No payment present with id " + id, HttpStatus.NOT_FOUND)
        );
        return PaymentMapper.paymentToPaymentDto(optionalPayment);
    }

    @Override
    public PaymentDto addPayment(PaymentDto paymentDto) {
        Card card = cardService.findByNumberOrCreateCard(CardMapper.cardDtoToCard(paymentDto.getCardDto()));

        Receiver receiver = receiverService.findByIbanOrCreateReceiver(ReceiverMapper
                .receiverDtoToReceiver(paymentDto.getReceiverDto()));

        Payment payment = new Payment();
        payment.setAmount(paymentDto.getAmount());
        payment.setPeriod(paymentDto.getPeriod());
        payment.setCard(card);
        payment.setReceiver(receiver);

        Payment savedPayment = paymentRepository.save(payment);
        return PaymentMapper.paymentToPaymentDto(savedPayment);
    }

    @Override
    public PaymentDto updatePayment(Long id, PaymentDto paymentDto) {
        if(paymentRepository.findById(id).isPresent()) {
            Payment existingPayment = paymentRepository.findById(id).get();
            existingPayment.setPeriod(paymentDto.getPeriod());
            existingPayment.setAmount(paymentDto.getAmount());

            Receiver existingReceiver = existingPayment.getReceiver();
            existingReceiver.setIban(paymentDto.getReceiverDto().getIban());
            existingReceiver.setMfo(paymentDto.getReceiverDto().getMfo());
            existingReceiver.setOkpo(paymentDto.getReceiverDto().getOkpo());
            existingReceiver.setName(paymentDto.getReceiverDto().getName());

            existingPayment.setReceiver(existingReceiver);

            Card existingCard = existingPayment.getCard();
            existingCard.setNumber(paymentDto.getCardDto().getNumber());

            Sender existingOwner = existingPayment.getCard().getOwner();
            existingOwner.setFirstName(paymentDto.getCardDto().getOwnerDto().getFirstName());
            existingOwner.setLastName(paymentDto.getCardDto().getOwnerDto().getLastName());

            existingCard.setOwner(existingOwner);

            existingPayment.setCard(existingCard);

            return PaymentMapper.paymentToPaymentDto(paymentRepository.save(existingPayment));
        } else {
            throw new PaymentException(String.format("No payment present with id %s", id), HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deletePayment(Long id) {
        paymentRepository.delete(PaymentMapper.paymentDtoToPayment(getPaymentById(id)));
    }

    @Override
    public List<PaymentDto> getPaymentsByCardOwnerInn(Long inn, Integer offset, Integer limit, String orderBy) {
        Pageable paging = PageRequest.of(offset, limit, Sort.by(orderBy).descending());
        List<Payment> paymentsByInn = paymentRepository.findByCardOwnerInn(inn, paging);
        return paymentsByInn.stream()
                .map(PaymentMapper::paymentToPaymentDto).toList();
    }

    @Override
    public List<PaymentDto> getPaymentsByReceiverOkpo(Long okpo, Integer offset, Integer limit, String orderBy) {
        Pageable paging = PageRequest.of(offset, limit, Sort.by(orderBy).descending());
        List<Payment> paymentsByReceiverOkpo = paymentRepository.findByReceiverOkpo(okpo, paging);
        return paymentsByReceiverOkpo.stream()
                .map(PaymentMapper::paymentToPaymentDto).toList();
    }
}
