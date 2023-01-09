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
            case "excellent": return RatingValue.EXCELLENT.getValue();
            case "good": return RatingValue.GOOD.getValue();
            case "average": return RatingValue.AVERAGE.getValue();
            case "poor": return RatingValue.POOR.getValue();
            case "very poor": return RatingValue.VERY_POOR.getValue();
            default: return 0;
        }
    }

    public static int calculateSocialCreditScore(List<Rating> ratings) {
        int totalRatingValue = 0;
        int totalWeight = 0;

        for (Rating rating : ratings) {
            int ratingValue = rating.getRating();
            int weight = rating.getWeight();
            totalRatingValue += ratingValue * weight;
            totalWeight += weight;
        }

        return totalRatingValue / totalWeight;
    }


}