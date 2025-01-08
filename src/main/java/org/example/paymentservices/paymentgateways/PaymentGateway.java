package org.example.paymentservices.paymentgateways;

public interface PaymentGateway {

    String initiatePayment(String email,Long amount,Long orderId,Long phoneNumber);
}
