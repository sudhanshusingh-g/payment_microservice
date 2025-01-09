package org.example.paymentservices.paymentgateways;

import com.stripe.exception.StripeException;

public interface PaymentGateway {

    String initiatePayment(String email,Long amount,Long orderId,Long phoneNumber) throws StripeException;
}
