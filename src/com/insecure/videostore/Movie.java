package com.insecure.videostore;

/**
 * Created with IntelliJ IDEA.
 * User: Karan.Khosla
 */

public abstract class Movie {
    private String title;

    public Movie(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    abstract int determineFrequentRenterPoints(int daysRented);

    abstract double determineRentalAmount(int daysRented);
}