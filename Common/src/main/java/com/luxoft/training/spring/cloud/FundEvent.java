package com.luxoft.training.spring.cloud;

import java.math.BigDecimal;

public class FundEvent extends AbstractFinancialEvent {
    private static final long serialVersionUID = 700671787171833738L;

    public FundEvent(String originService, String destinationService, BigDecimal sum) {
        super(originService, destinationService, sum);
    }
}
