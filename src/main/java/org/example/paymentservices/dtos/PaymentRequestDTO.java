package org.example.paymentservices.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentRequestDTO {
    private Long orderId;
    private String email;
    private Long phoneNumber;
    private Long amount;

}
