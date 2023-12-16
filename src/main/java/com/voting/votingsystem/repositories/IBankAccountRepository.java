package com.voting.votingsystem.interfaces;

import com.voting.votingsystem.Entities.EBankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBankAccountRepository extends JpaRepository<EBankAccount, Long> {
    // You can add custom queries if needed
}
