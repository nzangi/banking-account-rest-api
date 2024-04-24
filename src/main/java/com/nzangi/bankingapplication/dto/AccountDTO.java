package com.nzangi.bankingapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountDTO {
    private Long accountId;
    private String accountHolderName;
    private double accountBalance;

}
