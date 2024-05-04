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
    @Min(value = 1, message = "Account Balance should be positive and greater than zero")
    @DecimalMin(value = "1.0", message = "Account Balance should be positive and greater than zero")
    @Digits(integer = 10, fraction = 2, message = "Account Balance should be a valid number with up to 10 digits in total and 2 decimal places")
    private double accountBalance;
}
//@Override
//public String toString(){
//    return "Account Details {"
//    "accountId=" + accountId +
//            ", accountHolderName='" + accountHolderName + '\'' +
//            ", accountBalance=" + accountBalance +
//            '}';
//}

//@Override
//public String toString() {
//    return "Account Details{" +
//            "accountId=" + accountId +
//            ", accountHolderName='" + accountHolderName + '\'' +
//            ", accountBalance=" + accountBalance +
//            '}';
//}
