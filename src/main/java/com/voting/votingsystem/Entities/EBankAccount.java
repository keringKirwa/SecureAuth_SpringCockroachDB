package com.voting.votingsystem.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bank_accounts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EBankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private int age;
    private String region;
    private Date accountExpiryDate;
    private String bankId;
    private int accountBalance;

}
