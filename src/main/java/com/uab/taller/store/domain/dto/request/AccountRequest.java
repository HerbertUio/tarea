package com.uab.taller.store.domain.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountRequest {
    int number;
    String currencyType;
    Double balance;

    public int generateAccountNumber () {
        int accountNumber = 10001;
        int randomNumber = (int) (Math.random() * 90000) + 10000;
        accountNumber = Integer.parseInt(String.valueOf(accountNumber) + String.valueOf(randomNumber));
        return accountNumber;
    }
}
