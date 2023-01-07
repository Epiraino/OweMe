package com.example.oweme.controllers;

import com.example.oweme.models.Loan;
import com.example.oweme.requests.LoanRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loans")
public class LoanController {

    @PostMapping
    public ResponseEntity<Loan> createLoan(@RequestBody LoanRequest request) {
        // create a new loan for the authenticated user
        Loan loan = ...;
        return ResponseEntity.status(HttpStatus.CREATED).body(loan);
    }

    @PutMapping("/{loanId}")
    public ResponseEntity<Loan> updateLoan(@PathVariable String loanId, @RequestBody LoanRequest request) {
        // update the status of a loan
        Loan loan = ...;
        return ResponseEntity.ok(loan);
    }
}
