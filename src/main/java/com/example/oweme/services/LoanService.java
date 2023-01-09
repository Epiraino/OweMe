package com.example.oweme.services;

import com.example.oweme.models.Loan;
import com.example.oweme.repos.LoanRepository;
import com.example.oweme.requests.LoanRequest;
import org.springframework.stereotype.Service;

@Service
public class LoanService {

    private final LoanRepository loanRepository;

    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public Loan createLoan(LoanRequest request) {
        // create a new loan for the authenticated user
        Loan loan = Loan.createLoan(getCurrentUserId(), request.getBorrowerId(), request.getAmount(), request.getDueDate());
        return loanRepository.save(loan);
    }

    public Loan updateLoan(String loanId, LoanRequest request) {
        // update the status of a loan
        Loan loan = loanRepository.findById(loanId).orElse(null);
        if (loan == null) {
            throw new LoanNotFoundException();
        }
        loan.setStatus(request.getStatus());
        return loanRepository.save(loan);
    }
}
