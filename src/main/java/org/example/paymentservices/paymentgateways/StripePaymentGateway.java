package org.example.paymentservices.paymentgateways;

import com.stripe.Stripe;
import com.stripe.StripeClient;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentLink;
import com.stripe.model.Price;
import com.stripe.param.PaymentLinkCreateParams;
import com.stripe.param.PriceCreateParams;
import org.example.paymentservices.configs.StripeClientConfig;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class StripePaymentGateway implements PaymentGateway {

    private StripeClient stripeClient;
    public StripePaymentGateway(StripeClient stripeClient){
        this.stripeClient = stripeClient;
    }


    @Override
    public String initiatePayment(String email, Long amount, Long orderId, Long phoneNumber) throws StripeException {

        PriceCreateParams priceCreateParams=
                PriceCreateParams.builder()
                        .setCurrency("inr")
                        .setUnitAmount(amount)
                        .setProductData(
                                PriceCreateParams.ProductData.builder()
                                        .setName("Order #"+orderId)
                                        .build()
                        )

                        .build();
        Price price=stripeClient.prices().create(priceCreateParams);


        PaymentLinkCreateParams params =
                PaymentLinkCreateParams.builder()
                        .addLineItem(
                                PaymentLinkCreateParams.LineItem.builder()
                                        .setPrice(price.getId())
                                        .setQuantity(1L)
                                        .build()
                        )
                        .setBillingAddressCollection(
                                PaymentLinkCreateParams.BillingAddressCollection.REQUIRED
                        )

                        .build();
        PaymentLink paymentLink = stripeClient.paymentLinks().create(params);

        return paymentLink.getUrl();
    }
}
