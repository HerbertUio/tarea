package com.uab.taller.store.usecase.account;

import com.uab.taller.store.domain.Account;
import com.uab.taller.store.domain.dto.request.UpdateAccountRequest;
import com.uab.taller.store.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateAccountUseCase {
    @Autowired
    IAccountService accountService;

    public Account execute (Long id, UpdateAccountRequest updateAccountRequest) {
        Account account = accountService.getById(id);
        if (account == null) {
            return null;
        }
        account.setBalance(updateAccountRequest.getBalance());
        account.setCurrencyType(updateAccountRequest.getCurrencyType());
        return accountService.save(account);
    }

}
