package com.nzangi.bankingapplication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id" )
    private Long accountId;
    @Column(name = "account_holder_name" )
    private String accountHolderName;
    @Column(name = "account_balance" )
    private double accountBalance;
}
