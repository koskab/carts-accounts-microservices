package com.example.items.service;

import com.example.items.dto.PaymentResponse;

public interface Service {

    PaymentResponse buyAllItems(Long cardNumber);

}
