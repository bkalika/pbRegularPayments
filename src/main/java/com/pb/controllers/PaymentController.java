package com.pb.controllers;

import com.pb.dto.PaymentDto;
import com.pb.services.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/v1/payments")
public class PaymentController {
    private final IPaymentService paymentService;

    @Autowired
    public PaymentController(IPaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping
    public ResponseEntity<List<PaymentDto>> getPayments() {
        return ResponseEntity.ok(paymentService.getPayments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentDto> getPaymentById(@PathVariable Long id) {
        return ResponseEntity.ok(paymentService.getPaymentById(id));
    }

    @PostMapping
    public ResponseEntity<PaymentDto> postPayment(
            @RequestBody PaymentDto paymentDto
    ) {
        return ResponseEntity.created(URI.create("/v1/payments"))
                .body(paymentService.addPayment(paymentDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PaymentDto> deletePayment(@PathVariable Long id) {
        paymentService.deletePayment(id);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PatchMapping("{id}")
    public ResponseEntity<PaymentDto> updatePayment(
            @PathVariable("id") Long id,
            @RequestBody PaymentDto paymentDto
    ) {
        return ResponseEntity.ok(paymentService.updatePayment(id, paymentDto));
    }

    @GetMapping("payments-by-inn/{inn}")
    public ResponseEntity<List<PaymentDto>> getPaymentsByCardOwnerInn(
            @PathVariable("inn") Long inn,
            @RequestParam(value = "offset", defaultValue = "0") Integer offset,
            @RequestParam(value = "limit", defaultValue = "15") Integer limit,
            @RequestParam(value = "orderBy", defaultValue = "id") String orderBy
    ) {
        List<PaymentDto> paymentsByInn = paymentService.getPaymentsByCardOwnerInn(inn, offset, limit, orderBy);
        return new ResponseEntity<>(paymentsByInn, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("payments-by-okpo/{okpo}")
    public ResponseEntity<List<PaymentDto>> getPaymentsByReceiverOkpo(
            @PathVariable("okpo") Long okpo,
            @RequestParam(value = "offset", defaultValue = "0") Integer offset,
            @RequestParam(value = "limit", defaultValue = "15") Integer limit,
            @RequestParam(value = "orderBy", defaultValue = "id") String orderBy
    ) {
        List<PaymentDto> paymentsByReceiverOkpo = paymentService.getPaymentsByReceiverOkpo(okpo, offset, limit, orderBy);
        return new ResponseEntity<>(paymentsByReceiverOkpo, new HttpHeaders(), HttpStatus.OK);
    }
}
