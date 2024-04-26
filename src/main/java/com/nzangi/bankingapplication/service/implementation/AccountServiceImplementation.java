package com.nzangi.bankingapplication.service.implementation;

import com.nzangi.bankingapplication.dto.AccountDTO;
import com.nzangi.bankingapplication.entity.Account;
import com.nzangi.bankingapplication.mapper.AccountMapper;
import com.nzangi.bankingapplication.repository.AccountRepository;
import com.nzangi.bankingapplication.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class AccountServiceImplementation implements AccountService {
    private AccountRepository accountRepository;

    @Autowired
    public AccountServiceImplementation(AccountRepository accountRepository) {
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

    @Override
    public AccountDTO deposit(Long accountId, double amountToDeposit) {
        Account account = accountRepository.findById(accountId).orElseThrow(
                () -> new RuntimeException("Account Doesn't Exists")
        );
        if(amountToDeposit <= 0){
            throw new RuntimeException("Amount to deposit must be greater than 0. Your current account balance "+account.getAccountBalance());
        }
        double totalAmount = account.getAccountBalance() + amountToDeposit;
        account.setAccountBalance(totalAmount);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDTO(savedAccount);
    }

    @Override
    public AccountDTO withdraw(Long accountId, double amountToWithdraw) {
        Account account = accountRepository.findById(accountId).orElseThrow(
                () -> new RuntimeException("Account ID "+accountId+" Doesn't Exists")
        );

        if(account.getAccountBalance() < amountToWithdraw){
            throw new RuntimeException("Insufficient amount on Account ID "+accountId+". Your current balance is: " + account.getAccountBalance());

        } else if (amountToWithdraw <=0) {
            throw new RuntimeException("Amount to withdraw must be greater than 0. Your current balance is: " + account.getAccountBalance());
        }
        double balance = account.getAccountBalance() - amountToWithdraw;
        account.setAccountBalance(balance);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDTO(savedAccount);
    }

    @Override
    public List<AccountDTO> getAllAccounts() {
        List<Account> accounts=accountRepository.findAll();
//        return accounts.stream().map((account) -> AccountMapper.mapToAccountDTO(account))
//                .collect(Collectors.toList());
        return accounts.stream().map(AccountMapper::mapToAccountDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAccount(Long accountId) {
        accountRepository.findById(accountId).orElseThrow(
                () -> new RuntimeException("Account with id "+accountId+" does not exists")
        );
        accountRepository.deleteById(accountId);
    }
}
