package com.example.oweme.models;

import java.util.List;

public class User {
    private String userId;
    private String name;
    private String email;
    private List<Rating> ratings;
    private int socialCreditScore;
    private List<Loan> loans;

    public void calculateSocialCreditScore() {
        this.socialCreditScore = Rating.calculateSocialCreditScore(ratings);
    }
    private int getRatingValue(String rating) {
        switch (rating) {
            case "excellent": return 5;
            case "good": return 4;
            case "average": return 3;
            case "poor": return 2;
            case "very poor": return 1;
            default: return 0;
        }
    }

    private int getWeight(int numLoans, int totalAmount) {
        // assign more weight

        // constructor, getters, and setters
}