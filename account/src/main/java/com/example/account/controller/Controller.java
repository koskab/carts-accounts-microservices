package com.example.account.controller;

import com.example.account.dto.BalanceView;
import com.example.account.dto.PaymentResponse;
import com.example.account.sevice.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class Controller {

    private final Service service;

    @PutMapping
    public PaymentResponse writeOff(@RequestParam Long cardNumber, @RequestParam BigDecimal cost){
        return service.writeOff(cardNumber, cost);
    }

    @GetMapping
    public BalanceView getBalance(@RequestParam Long cardNumber){
        return service.getBalance(cardNumber);
    }

}
