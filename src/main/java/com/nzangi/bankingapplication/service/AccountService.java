package com.nzangi.bankingapplication.service;

import com.nzangi.bankingapplication.dto.AccountDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {
    AccountDTO createAccount(AccountDTO accountDTO);
    AccountDTO getAccountById(Long accountId);
    AccountDTO deposit(Long accountId,double amountToDeposit);
    AccountDTO withdraw(Long accountId, double amountToWithdraw);
    List<AccountDTO> getAllAccounts();
    void deleteAccount(Long accountId);

}
