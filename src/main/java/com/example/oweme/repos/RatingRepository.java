package com.example.oweme.repos;

import com.example.oweme.models.Rating;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface RatingRepository extends CrudRepository<Rating, String> {
    // custom queries to create and retrieve ratings
}