package com.nzangi.bankingapplication.controller;

import com.nzangi.bankingapplication.dto.AccountDTO;
import com.nzangi.bankingapplication.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    //add account rest-api

    @PostMapping("/addAccount")
    public ResponseEntity<AccountDTO> addAccount(@RequestBody AccountDTO accountDTO){
        return new ResponseEntity<>(accountService.createAccount(accountDTO), HttpStatus.CREATED);
    }
    //Get account By Id REST API
    @GetMapping("/account/{accountId}")
    public  ResponseEntity<AccountDTO> getAccountById(@PathVariable Long accountId){
        AccountDTO accountDTO = accountService.getAccountById(accountId);
        return ResponseEntity.ok(accountDTO);
    }
}
