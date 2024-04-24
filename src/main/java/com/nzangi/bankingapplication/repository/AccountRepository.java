package com.nzangi.bankingapplication.repository;

import com.nzangi.bankingapplication.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
}
