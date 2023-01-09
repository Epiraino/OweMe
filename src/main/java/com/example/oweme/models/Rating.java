package com.example.oweme.models;

import java.util.List;
import java.util.Objects;

public class Rating {

    private String lenderId;
    private String borrowerId;
    private String loanId;
    private int rating;
    private int numLoans;
    private int totalAmount;
    private int weight;


    private static int getRatingValue(String rating) {
        switch (rating) {
            case "excellent": return RatingValue.EXCELLENT.getValue();
            case "good": return RatingValue.GOOD.getValue();
            case "average": return RatingValue.AVERAGE.getValue();
            case "poor": return RatingValue.POOR.getValue();
            case "very poor": return RatingValue.VERY_POOR.getValue();
            default: return 0;
        }
    }


//
    // getters and setters

    public Rating(String loanId, String borrowerId, int rating, String comment) {
        this.loanId = loanId;
        this.userId = userId;
        this. = userName;
        this.rating = rating;
        this.comment = comment;
    }

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    private int getWeight(int amount, int daysOutstanding) {
        int amountBasedWeight = 1;
        if (amount >= 500 && amount < 1000) {
            amountBasedWeight = 2;
        } else if (amount >= 1000) {
            amountBasedWeight = 3;
        }


        int timeBasedWeight = 1;
        if (daysOutstanding >= 30 && daysOutstanding < 60) {
            timeBasedWeight = 2;
        } else if (daysOutstanding >= 60 && daysOutstanding < 90) {
            timeBasedWeight = 3;
        } else if (daysOutstanding >= 90) {
            timeBasedWeight = 4;
        }

        return amountBasedWeight + numLoansBasedWeight + timeBasedWeight;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rating rating1 = (Rating) o;
        return rating == rating1.rating && Objects.equals(loanId, rating1.loanId) && Objects.equals(userId, rating1.userId) && Objects.equals(userName, rating1.userName) && Objects.equals(comment, rating1.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loanId, userId, userName, rating, comment);
    }


}