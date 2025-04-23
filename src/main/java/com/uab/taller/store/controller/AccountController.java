package com.uab.taller.store.controller;

import com.uab.taller.store.domain.Account;
import com.uab.taller.store.domain.dto.request.CreateAccountRequest;
import com.uab.taller.store.domain.dto.request.UpdateAccountRequest;
import com.uab.taller.store.service.IUserService;
import com.uab.taller.store.usecase.account.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/accounts")
public class AccountController {
    @Autowired
    IUserService userService;

    @Autowired
    CreateAccountUseCase createAccountUseCase;
    @Autowired
    GetAllAccountsUseCase getAllAccountsUseCase;
    @Autowired
    GetAccountByIdUseCase getAccountByIdUseCase;
    @Autowired
    DeleteAccountUseCase deleteAccountUseCase;
    @Autowired
    UpdateAccountUseCase updateAccountUseCase;

    @GetMapping
    public List<Account> getAllAccounts() {
        return getAllAccountsUseCase.execute();
    }
    @GetMapping(value = "/{accountId}")
    public Account getAccountById(@PathVariable Long id) {
        return getAccountByIdUseCase.execute(id);
    }
    @DeleteMapping(value = "/{accountId}")
    public void deleteAccountById(@PathVariable Long id) {
        deleteAccountUseCase.execute(id);
    }
    @PostMapping("")
    public Account save(@RequestBody CreateAccountRequest createAccountRequest) {
        return createAccountUseCase.execute(createAccountRequest);
    }
    @PutMapping("/{id}")
    public Account update(@PathVariable long id, @RequestBody UpdateAccountRequest updateAccountRequest) {
        return updateAccountUseCase.execute(id, updateAccountRequest);
    }

}
