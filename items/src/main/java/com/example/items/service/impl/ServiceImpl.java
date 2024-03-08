package com.example.items.service.impl;

import com.example.items.clients.AccountsClient;
import com.example.items.dto.PaymentResponse;
import com.example.items.entity.Item;
import com.example.items.repository.Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceImpl implements com.example.items.service.Service {

    private final Repository repository;
    private final AccountsClient client;

    @Transactional
    public PaymentResponse buyAllItems(Long cardNumber){
        List<Item> items = repository.findAll();
        BigDecimal cost = items.stream().map(Item::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);

        PaymentResponse response = client.writeOff(cardNumber, cost);
        repository.deleteAll(items);
        return response;
    }

}
