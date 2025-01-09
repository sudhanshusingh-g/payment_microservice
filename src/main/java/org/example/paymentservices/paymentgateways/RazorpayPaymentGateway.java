package org.example.paymentservices.paymentgateways;

import org.springframework.stereotype.Component;

@Component
public class RazorpayPaymentGateway implements PaymentGateway {
    @Override
    public String initiatePayment(String email, Long amount, Long orderId, Long phoneNumber) {
        return "";
    }
}
