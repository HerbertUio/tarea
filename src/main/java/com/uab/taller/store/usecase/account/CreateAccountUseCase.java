package com.uab.taller.store.usecase.account;

import com.uab.taller.store.domain.Account;
import com.uab.taller.store.domain.dto.request.CreateAccountRequest;
import com.uab.taller.store.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateAccountUseCase {
    @Autowired
    IAccountService accountService;
    public Account execute(CreateAccountRequest accountRequest){
        Account account = new Account();
        account.setNumber(accountRequest.generateAccountNumber());
        account.setBalance(accountRequest.getBalance());
        account.setCurrencyType(accountRequest.getCurrencyType());
        return accountService.save(account);
    }
}
