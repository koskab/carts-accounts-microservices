package com.example.items.controllers;

import com.example.items.dto.PaymentResponse;
import com.example.items.service.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class Controller {

    private final Service service;

    @PutMapping
    public PaymentResponse buyAllItems(@RequestParam Long cardNumber) {
        return service.buyAllItems(cardNumber);
    }

}
