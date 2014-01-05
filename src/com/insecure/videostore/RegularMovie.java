package com.insecure.videostore;

/**
 * Created with IntelliJ IDEA.
 * User: Karan.Khosla
 */

public class RegularMovie extends Movie {
    public RegularMovie(String title) {
        super(title);
    }

    int determineFrequentRenterPoints(int daysRented) {
        return 1;
    }

    double determineRentalAmount(int daysRented) {
        double thisAmount = 2;
        if (daysRented > 2)
            thisAmount += (daysRented - 2) * 1.5;
        return thisAmount;
    }
}
