package com.example.oweme.models;

public enum RatingValue {
    EXCELLENT(5),
    GOOD(4),
    AVERAGE(3),
    POOR(2),
    VERY_POOR(1);

    private final int value;

    RatingValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
