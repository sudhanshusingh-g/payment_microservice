package org.example.paymentservices.controllers;

import com.stripe.exception.StripeException;
import org.example.paymentservices.dtos.PaymentRequestDTO;
import org.example.paymentservices.services.PaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    private PaymentService paymentService;
    public PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    @PostMapping
    public String createPaymentLink(@RequestBody PaymentRequestDTO request) throws StripeException {
        return paymentService.createPaymentLink(
                request.getEmail(),
                request.getAmount(),
                request.getOrderId(),
                request.getPhoneNumber()
        );
    }
}
