package com.example.oweme.models;

import java.util.List;

public class Loan {
    private String loanId;
    private String borrowerId;
    private String borrowerName;
    private int amount;
    private String dueDate;
    private boolean paid;
    private List<Rating> ratings;
    private String status;

    private int daysOutstanding;

    // constructor, getters, and setters

    private Loan(String loanId, String borrowerId, String borrowerName, int amount, String dueDate, boolean paid, List<Rating> ratings, String status) {
        this.loanId = loanId;
        this.borrowerId = borrowerId;
        this.borrowerName = borrowerName;
        this.amount = amount;
        this.dueDate = dueDate;
        this.paid = paid;
        this.ratings = ratings;
        this.status = status;
    }

    public static Loan createLoan(String loanId, String borrowerId, String borrowerName, int amount, String dueDate, boolean paid, List<Rating> ratings, String status) {
        return new Loan(loanId, borrowerId, borrowerName, amount, dueDate, paid, ratings, status);
    }
}