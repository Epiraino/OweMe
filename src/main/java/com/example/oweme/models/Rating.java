package com.example.oweme.models;

import java.util.List;
import java.util.Objects;

public class Rating {
    private String id;
    private String lenderId;
    private String borrowerId;
    private int rating;
    private int numLoans;
    private int totalAmount;
    private int weight;

    public static int calculateSocialCreditScore(List<Rating> ratings) {
        int totalRatingValue = 0;
        int totalWeight = 0;

        for (Rating rating : ratings) {
            int ratingValue = getRatingValue(rating.getRating());
            int weight = rating.getWeight();
            totalRatingValue += ratingValue * weight;
            totalWeight += weight;
        }

        return totalRatingValue / totalWeight;
    }

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

    public Rating(String loanId, String userId, String userName, int rating, String comment) {
        this.loanId = loanId;
        this.userId = userId;
        this.userName = userName;
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
    private static int getWeight(int numLoans, int totalAmount) {
        // assign more weight to loans with higher amounts or more loans in total

        return numLoans * totalAmount;
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