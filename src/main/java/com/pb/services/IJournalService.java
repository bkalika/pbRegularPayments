package com.pb.services;

import com.pb.dto.JournalDto;

import java.util.List;

/**
 * @author @bkalika
 */
public interface IJournalService {
    JournalDto getJournalById(Long id);
    JournalDto addJournal(JournalDto journalDto);
    void deleteJournal(Long id);
    JournalDto updateJournal(Long id, JournalDto journalDto);
    List<JournalDto> getJournalsByPaymentId(Long paymentId, Integer offset, Integer limit, String orderBy);
}
