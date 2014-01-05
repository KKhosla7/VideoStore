package com.insecure.videostore;

/**
 * Created with IntelliJ IDEA.
 * User: Karan.Khosla
 */

public class ChildrenMovie extends Movie {
    public ChildrenMovie(String title) {
        super(title);
    }

    int determineFrequentRenterPoints(int daysRented) {
        return 1;
    }

    double determineRentalAmount(int daysRented) {
        double thisAmount = 1.5;
        if (daysRented > 3)
            thisAmount += (daysRented - 3) * 1.5;
        return thisAmount;
    }
}
