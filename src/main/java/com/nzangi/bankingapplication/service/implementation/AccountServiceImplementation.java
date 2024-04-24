package com.nzangi.bankingapplication.service.implementation;

import com.nzangi.bankingapplication.dto.AccountDTO;
import com.nzangi.bankingapplication.entity.Account;
import com.nzangi.bankingapplication.mapper.AccountMapper;
import com.nzangi.bankingapplication.repository.AccountRepository;
import com.nzangi.bankingapplication.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AccountServiceImplementation implements AccountService {
    private AccountRepository accountRepository;
    @Autowired
    public AccountServiceImplementation(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDTO createAccount(AccountDTO accountDTO) {
        Account account = AccountMapper.mapToAccount(accountDTO);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDTO(savedAccount);
    }

    @Override
    public AccountDTO getAccountById(Long accountId) {
        Account account = accountRepository.findById(accountId).orElseThrow(
                () -> new RuntimeException("Account Doesn't Exists")
        );

        return AccountMapper.mapToAccountDTO(account);
    }
}
