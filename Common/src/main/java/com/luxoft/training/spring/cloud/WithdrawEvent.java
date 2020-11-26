package com.luxoft.training.spring.cloud;

import java.math.BigDecimal;

public class WithdrawEvent extends AbstractFinancialEvent {
    private static final long serialVersionUID = 3166350018059271242L;

    public WithdrawEvent(String originService, String destinationService, BigDecimal sum) {
        super(originService, destinationService, sum);
    }

}
