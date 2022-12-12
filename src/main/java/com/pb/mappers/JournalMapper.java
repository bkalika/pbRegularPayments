package com.pb.mappers;

import com.pb.dto.JournalDto;
import com.pb.entities.Journal;

/**
 * @author @bkalika
 */
public class JournalMapper {
    public static Journal journalDtoToJournal(JournalDto journalDto) {
        Journal journal = new Journal();
        journal.setId(journalDto.getId());
        journal.setAmount(journalDto.getAmount());
        journal.setTime(journalDto.getTime());
        journal.setStatus(journalDto.getStatus());
        journal.setPayment(PaymentMapper.paymentDtoToPayment(journalDto.getPaymentDto()));
        return journal;
    }

    public static JournalDto journalToJournalDto(Journal journal) {
        JournalDto journalDto = new JournalDto();
        journalDto.setId(journal.getId());
        journalDto.setAmount(journal.getAmount());
        journalDto.setTime(journal.getTime());
        journalDto.setStatus(journal.getStatus());
        journalDto.setPaymentDto(PaymentMapper.paymentToPaymentDto(journal.getPayment()));
        return journalDto;
    }
}
