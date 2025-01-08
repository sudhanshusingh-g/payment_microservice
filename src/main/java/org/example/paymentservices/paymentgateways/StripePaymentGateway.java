package org.example.paymentservices.paymentgateways;

import org.springframework.stereotype.Service;

@Service
public class StripePaymentGateway implements PaymentGateway {

    @Override
    public String initiatePayment(String email, Long amount, Long orderId, Long phoneNumber) {
        return "";
    }
}
