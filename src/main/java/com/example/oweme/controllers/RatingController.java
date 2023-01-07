package com.example.oweme.controllers;

import com.example.oweme.models.Rating;
import com.example.oweme.requests.RatingRequest;
import com.example.oweme.services.RatingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    private final RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody RatingRequest request) {
        Rating rating = ratingService.createRating(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(rating);
    }
}
