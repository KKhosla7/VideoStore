package com.insecure.videostore;

/**
 * Created with IntelliJ IDEA.
 * User: Karan.Khosla
 */

public class NewReleaseMovie extends Movie {
    public NewReleaseMovie(String title) {
        super(title);
    }

    int determineFrequentRenterPoints(int daysRented) {
        if (daysRented > 1) return 2;
        else return 1;
    }

    double determineRentalAmount(int daysRented) {
        return daysRented * 3;
    }
}
