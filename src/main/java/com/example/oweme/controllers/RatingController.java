package com.example.oweme.controllers;

import com.example.oweme.models.Rating;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody RatingRequest request) {
        // create a new rating for a loan
        Rating rating = ...;
        return ResponseEntity.status(HttpStatus.CREATED).body(rating);
    }
}
