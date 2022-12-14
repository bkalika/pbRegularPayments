package com.pb.services.implementations;

import com.pb.dto.JournalDto;
import com.pb.entities.Journal;
import com.pb.entities.Payment;
import com.pb.mappers.JournalMapper;
import com.pb.mappers.PaymentMapper;
import com.pb.repositories.JournalRepository;
import com.pb.services.IJournalService;
import com.pb.services.IPaymentService;
import com.pb.exceptions.JournalException;
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
public class JournalService implements IJournalService {
    private final JournalRepository journalRepository;
    private final IPaymentService paymentService;

    public JournalService(JournalRepository journalRepository, IPaymentService paymentService) {
        this.journalRepository = journalRepository;
        this.paymentService = paymentService;
    }

    @Override
    public List<JournalDto> getJournals() {
        List<Journal> journals = journalRepository.findAll();
        return journals.stream().map(JournalMapper::journalToJournalDto).toList();
    }

    @Override
    public JournalDto getJournalById(Long id) {
        Journal journal = journalRepository.findById(id)
                .orElseThrow(() -> new JournalException("No journal present with id " + id, HttpStatus.NOT_FOUND));
        return JournalMapper.journalToJournalDto(journal);
    }

    @Override
    public JournalDto addJournal(JournalDto journalDto) {
        Payment payment = PaymentMapper.paymentDtoToPayment(
                paymentService.getPaymentById(journalDto.getPaymentDto().getId()));

        Journal journal = new Journal();
        journal.setPayment(payment);
        journal.setAmount(journalDto.getAmount());
        journal.setStatus(journalDto.getStatus());

        Journal savedJournal = journalRepository.save(journal);
        return JournalMapper.journalToJournalDto(savedJournal);
    }

    @Override
    public void deleteJournal(Long id) {
        journalRepository.delete(JournalMapper.journalDtoToJournal(getJournalById(id)));
    }

    @Override
    public JournalDto updateJournal(Long id, JournalDto journalDto) {
        if(journalRepository.findById(id).isPresent()) {
            Journal existingJournal = journalRepository.findById(id).get();
            existingJournal.setAmount(journalDto.getAmount());
            existingJournal.setStatus(journalDto.getStatus());

            return JournalMapper.journalToJournalDto(journalRepository.save(existingJournal));
        } else {
            throw new JournalException(String.format("The is no journal with id %s.", id), HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public List<JournalDto> getJournalsByPaymentId(Long paymentId, Integer offset, Integer limit, String orderBy) {
        Pageable paging = PageRequest.of(offset, limit, Sort.by(orderBy).descending());
        List<Journal> journalsByPaymentId = journalRepository.findByPaymentId(paymentId, paging);
        return journalsByPaymentId.stream()
                .map(JournalMapper::journalToJournalDto).toList();
    }
}
