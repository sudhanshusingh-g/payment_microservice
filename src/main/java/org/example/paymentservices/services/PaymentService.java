package org.example.paymentservices.services;

import com.stripe.exception.StripeException;
import org.example.paymentservices.paymentgateways.PaymentGateway;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private PaymentGateway paymentGateway;

    public PaymentService(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public String createPaymentLink(String email,Long amount,Long orderId,Long phoneNumber) throws StripeException {
       return paymentGateway.initiatePayment(email,amount,orderId,phoneNumber);
    }
}
