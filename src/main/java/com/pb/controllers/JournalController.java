package com.pb.controllers;

import com.pb.dto.JournalDto;
import com.pb.services.IJournalService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

/**
 * @author @bkalika
 */
@RestController
@RequestMapping("/v1/journals")
public class JournalController {
    private final IJournalService journalService;

    public JournalController(IJournalService journalService) {
        this.journalService = journalService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<JournalDto> getJournalById(@PathVariable Long id) {
        return ResponseEntity.ok(journalService.getJournalById(id));
    }

    @PostMapping
    public ResponseEntity<JournalDto> postJournal(
            @RequestBody JournalDto journalDto
    ) {
        return ResponseEntity.created(URI.create("/v1/journals"))
                .body(journalService.addJournal(journalDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<JournalDto> deleteJournal(@PathVariable Long id) {
        journalService.deleteJournal(id);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<JournalDto> updateJournal(
            @PathVariable("id") Long id,
            @RequestBody JournalDto journalDto
    ) {
        return ResponseEntity.ok(journalService.updateJournal(id, journalDto));
    }

    @GetMapping("/journals-by-payments/{paymentId}")
    public ResponseEntity<List<JournalDto>> getJournalsByPaymentId(
            @PathVariable("paymentId") Long paymentId,
            @RequestParam(value = "offset", defaultValue = "0") Integer offset,
            @RequestParam(value = "limit", defaultValue = "15") Integer limit,
            @RequestParam(value = "orderBy", defaultValue = "id") String orderBy
    ) {
        List<JournalDto> journalsByPayment = journalService.getJournalsByPaymentId(paymentId, offset, limit, orderBy);
        return new ResponseEntity<>(journalsByPayment, new HttpHeaders(), HttpStatus.OK);
    }
}
