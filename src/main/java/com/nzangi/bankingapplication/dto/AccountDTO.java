package com.nzangi.bankingapplication.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountDTO {
    private Long accountId;
    @NotNull(message = "This field is required!")
    @NotEmpty(message = "You should Enter Account Holder Name")
    private String accountHolderName;
    @NotNull(message = "This field is required!")
    @Positive(message = "Account Balance should be positive")
//    @Pattern(regexp = "[0-9]+",message = "Account Balance should be int only")
    @Min(1)
    private double accountBalance;

}
