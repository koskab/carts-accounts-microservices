package com.example.items.clients;

import com.example.items.dto.PaymentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@FeignClient(name = "accounts", url = "http://localhost:9090/accounts")
public interface AccountsClient {

    @PutMapping
    PaymentResponse writeOff(@RequestParam Long cardNumber, @RequestParam BigDecimal cost);

}
