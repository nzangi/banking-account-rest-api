package com.nzangi.bankingapplication.controller;

import com.nzangi.bankingapplication.dto.AccountDTO;
import com.nzangi.bankingapplication.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<AccountDTO> addAccount(@RequestBody AccountDTO accountDTO){
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
    public ResponseEntity<AccountDTO> deposit(@PathVariable Long accountId, @RequestBody Map<String,Double> request){
        Double amountToDeposit = request.get("amountToDeposit");
        AccountDTO accountDTO = accountService.deposit(accountId,amountToDeposit);
        return ResponseEntity.ok(accountDTO);
    }
    @PutMapping("/withdraw/{accountId}")
    public ResponseEntity<AccountDTO> withdraw(@PathVariable Long accountId,@RequestBody Map<String,Double> request){
        Double amountToWithdraw = request.get("amountToWithdraw");

        AccountDTO accountDTO = accountService.withdraw(accountId,amountToWithdraw);
        return ResponseEntity.ok(accountDTO);
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
        accountService.deleteAccount(accountId);
        return ResponseEntity.ok("Account Deleted successfully!");
    }


}
