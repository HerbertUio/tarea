package com.uab.taller.store.usecase.account;

import com.uab.taller.store.domain.Account;
import com.uab.taller.store.domain.User;
import com.uab.taller.store.domain.dto.request.CreateAccountRequest;
import com.uab.taller.store.service.IAccountService;
import com.uab.taller.store.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateAccountUseCase {
    @Autowired
    IAccountService accountService;
    @Autowired
    IUserService userService;
    public Account execute(Long userId,CreateAccountRequest accountRequest){
        User user = userService.getById(userId);
        Account account = new Account();
        account.setNumber(generateAccountNumber());
        account.setBalance(accountRequest.getBalance());
        account.setCurrencyType(accountRequest.getCurrencyType());
        account.setUser(user);
        return accountService.save(account);
    }
    public int generateAccountNumber() {
        int accountNumber = 10001;
        int randomNumber = (int) (Math.random() * 90000) + 10000;
        accountNumber = Integer.parseInt(String.valueOf(accountNumber) + String.valueOf(randomNumber));
        return accountNumber;
    }
}
