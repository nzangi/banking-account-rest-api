package com.nzangi.bankingapplication.mapper;

import com.nzangi.bankingapplication.dto.AccountDTO;
import com.nzangi.bankingapplication.entity.Account;

public class AccountMapper {
    public static Account mapToAccount(AccountDTO accountDTO){
        Account account = new Account(
                accountDTO.getAccountId(),
                accountDTO.getAccountHolderName(),
                accountDTO.getAccountBalance()
        );
        return account;
    }
    public static  AccountDTO mapToAccountDTO(Account account){
        AccountDTO accountDTO = new AccountDTO(
                account.getAccountId(),
                account.getAccountHolderName(),
                account.getAccountBalance()
        );
        return accountDTO;
    }
}
