package com.insecure.videostore;

/**
 * Created with IntelliJ IDEA.
 * User: Karan.Khosla
 */


import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String customerName;
    private List<Rental> rentals = new ArrayList<Rental>();
    private double totalAmount = 0;
    private int frequentRenterPoints = 0;

    public Customer(String customerName) {
        this.customerName = customerName;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String statement() {
        String result = header();
        result = renterLines(result);
        result += footer();
        return result;
    }

    private String header() {
        return String.format("Rental Record for %s\n", customerName);
    }

    private String renterLines(String renterLine) {
        for (Rental rental : rentals) {
            totalAmount += rental.determineRentalAmount();
            frequentRenterPoints += rental.determineFrequentRenterPoints();
            renterLine += String.format("\t%s\t%.1f\n", rental.movieTitle(), rental.determineRentalAmount());
        }
        return renterLine;
    }

    private String footer() {
        return String.format("You owed %.1f\nYou earned %d frequent renter points\n", totalAmount, frequentRenterPoints);
    }

    public double totalAmount() {
        return totalAmount;
    }

    public int earnedFrequentRenterPoints() {
        return frequentRenterPoints;
    }
}