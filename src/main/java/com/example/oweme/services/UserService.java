package com.example.oweme.services;

import com.example.oweme.models.User;
import com.example.oweme.repos.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getCurrentUser() {
        // retrieve authenticated user's profile
        User user = userRepository.findById(getCurrentUserId()).orElse(null);
        if (user == null) {
            throw new UserNotFoundException();
        }
        // retrieve authenticated user's loan history
        user.setLoans(userRepository.findLoansByUserId(getCurrentUserId()));
        return user;
    }
}
