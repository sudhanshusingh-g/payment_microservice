package org.example.paymentservices.configs;

import com.stripe.Stripe;
import com.stripe.StripeClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StripeClientConfig {
    @Value("${stripe.key.secret}")
    private String stripeKey;
    @Bean
    public StripeClient stripeClient() {
        return new StripeClient(stripeKey);
    }
}
