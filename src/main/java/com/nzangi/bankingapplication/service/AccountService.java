package com.nzangi.bankingapplication.service;

import com.nzangi.bankingapplication.dto.AccountDTO;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {
    AccountDTO createAccount(AccountDTO accountDTO);
    AccountDTO getAccountById(Long accountId);
}
