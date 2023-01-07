package com.example.oweme.repos;

import com.example.oweme.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
    // custom queries to retrieve user information and loan history
}
