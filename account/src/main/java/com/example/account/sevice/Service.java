package com.example.account.sevice;

import com.example.account.dto.BalanceView;
import com.example.account.dto.PaymentResponse;

import java.math.BigDecimal;

public interface Service {

    PaymentResponse writeOff(Long cardNumber, BigDecimal cost);

    BalanceView getBalance(Long cardNumber);

}
