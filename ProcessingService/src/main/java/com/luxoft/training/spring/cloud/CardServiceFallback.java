package com.luxoft.training.spring.cloud;

import com.luxoft.training.spring.cloud.CardServiceClient;
import org.springframework.stereotype.Component;

@Component
public class CardServiceFallback implements CardServiceClient {
    @Override
    public String createCard() {
        return null;
    }
}
