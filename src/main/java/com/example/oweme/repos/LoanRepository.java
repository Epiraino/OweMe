package com.example.oweme.repos;

import com.example.oweme.models.Loan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends CrudRepository<Loan, String> {
    // custom queries to create, update, and retrieve loans
}