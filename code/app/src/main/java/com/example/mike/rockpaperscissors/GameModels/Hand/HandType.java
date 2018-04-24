package com.example.mike.rockpaperscissors.GameModels.Hand;

public enum HandType {
    ROCK("Rock"),
    PAPER("Paper"),
    SCISSORS("Scissors");

    private final String name;

    HandType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
