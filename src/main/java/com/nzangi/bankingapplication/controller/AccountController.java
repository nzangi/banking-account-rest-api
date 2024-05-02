package com.nzangi.bankingapplication.controller;

import com.nzangi.bankingapplication.dto.AccountDTO;
import com.nzangi.bankingapplication.exceptions.ErrorRuntimeException;
import com.nzangi.bankingapplication.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    //add account rest-api

    @PostMapping("/add-account")
    public ResponseEntity<AccountDTO> addAccount(@Valid @RequestBody AccountDTO accountDTO){
        return new ResponseEntity<>(accountService.createAccount(accountDTO), HttpStatus.CREATED);
    }
    //Get account By Id REST API
    @GetMapping("/account/{accountId}")
    public  ResponseEntity<AccountDTO> getAccountById(@PathVariable Long accountId){
        AccountDTO accountDTO = accountService.getAccountById(accountId);
        return ResponseEntity.ok(accountDTO);
    }

    //Deposit REST API
    @PutMapping("/deposit/{accountId}")
    public ResponseEntity<?> deposit(@PathVariable Long accountId, @RequestBody Map<String,Double> request){
        try {
            Double amountToDeposit = request.get("amountToDeposit");
            AccountDTO accountDTO = accountService.deposit(accountId,amountToDeposit);
            return ResponseEntity.ok(accountDTO);
        }catch (ErrorRuntimeException exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }

    }
    @PutMapping("/withdraw/{accountId}")
    public ResponseEntity<?> withdraw(@PathVariable Long accountId,@RequestBody Map<String,Double> request){
        try {
            Double amountToWithdraw = request.get("amountToWithdraw");
            AccountDTO accountDTO = accountService.withdraw(accountId,amountToWithdraw);
            return ResponseEntity.ok(accountDTO);
        }catch (ErrorRuntimeException exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }

    }
//    get all accounts REST API
    @GetMapping("/")
    public ResponseEntity<List<AccountDTO>> getAllAccounts(){
        List<AccountDTO> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }
    //delete account REST API

    @DeleteMapping("/delete-account/{accountId}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long accountId ){
        try {
            accountService.deleteAccount(accountId);
            return ResponseEntity.ok("Account Deleted successfully!");
        }catch (ErrorRuntimeException exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }

    }

}
