package org.example.paymentservices.paymentgateways;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class RazorpayPaymentGateway implements PaymentGateway {
    @Override
    public String initiatePayment(String email, Long amount, Long orderId, Long phoneNumber) {
        return "";
    }
}
