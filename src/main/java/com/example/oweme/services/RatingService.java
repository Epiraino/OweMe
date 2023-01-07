package com.example.oweme.services;

import com.example.oweme.models.Rating;
import com.example.oweme.requests.RatingRequest;
import org.springframework.stereotype.Service;

@Service
public class RatingService {

    public Rating createRating(RatingRequest request) {
        // create a new rating for a loan
        Rating rating = new Rating(request.getLoanId(), getCurrentUserId(), getCurrentUserName(), request.getRating(), request.getComment());
        return ratingRepository.save(rating);
    }
}
