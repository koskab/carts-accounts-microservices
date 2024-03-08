package com.example.account.sevice.impl;

import com.example.account.dto.BalanceView;
import com.example.account.dto.PaymentResponse;
import com.example.account.entity.Account;
import com.example.account.repository.AccountsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ServiceImpl implements com.example.account.sevice.Service {

    private final AccountsRepository repository;

    @Override
    @Transactional
    public PaymentResponse writeOff(Long cardNumber, BigDecimal cost){
        Account account = repository.findByCardNumber(cardNumber)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        if (account.getBalance().compareTo(cost) < 0)
            throw new RuntimeException("Balance is too low");

        account.writeOff(cost);
        account = repository.save(account);
        return new PaymentResponse(account.getId());
    }

    @Transactional(readOnly = true)
    public BalanceView getBalance(Long cardNumber){
        Account account = repository.findByCardNumber(cardNumber)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        return new BalanceView(account.getBalance());
    }

}
