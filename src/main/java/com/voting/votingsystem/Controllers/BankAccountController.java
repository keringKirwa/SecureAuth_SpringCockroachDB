package com.voting.votingsystem.Controllers;

import com.voting.votingsystem.Entities.LoginRequest;
import com.voting.votingsystem.Services.BankAccountService;
import com.voting.votingsystem.utils.AnalyticsAPI;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/bank-accounts")
public class BankAccountController {

    /*Now in spring boot : recommended: Constructor Injection*/

    private final BankAccountService bankAccountService;

    @Autowired
    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @GetMapping("/createAndSaveBankAccount")
    @NotNull
    public ResponseEntity<Object> createAndSaveBankAccount(@NotNull @RequestBody LoginRequest loginRequest) {
        try {
            return new ResponseEntity<>(bankAccountService.createAndSaveBankAccount(), HttpStatus.OK);


        } catch (BadCredentialsException e) {

            e.printStackTrace();

            AnalyticsAPI.analyticsLogging(e.getLocalizedMessage());
            return new ResponseEntity<>("Error creating a Bank Account", HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

}


