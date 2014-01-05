package com.insecure.videostore;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Karan.Khosla
 */

public class VideoStoreTest {
    private final double DELTA = .001;
    private Customer customer;
    private Movie newReleaseMovie1;
    private Movie newReleaseMovie2;
    private Movie childrenMovie1;
    private Movie regularMovie1;
    private Movie regularMovie2;
    private Movie regularMovie3;

    public VideoStoreTest() {
    }

    @Before
    public void setUp() {
        customer = new Customer("Fred");
        newReleaseMovie1 = new NewReleaseMovie("The Cell");
        newReleaseMovie2 = new NewReleaseMovie("The Tigger Movie");
        childrenMovie1 = new ChildrenMovie("The Tigger Movie");
        regularMovie1 = new RegularMovie("Plan 9 from Outer Space");
        regularMovie2 = new RegularMovie("8 1/2");
        regularMovie3 = new RegularMovie("Eraserhead");
    }

    @Test
    public void testSingleNewReleaseStatementTotals() {
        customer.addRental(new Rental(newReleaseMovie1, 3));
        customer.addRental(new Rental(newReleaseMovie1, 1));
        customer.statement();
        assertEquals(12.0, customer.totalAmount(), DELTA);
        assertEquals(3, customer.earnedFrequentRenterPoints());
    }

    @Test
    public void testDualNewReleaseStatementTotals() {
        customer.addRental(new Rental(newReleaseMovie1, 3));
        customer.addRental(new Rental(newReleaseMovie2, 3));
        customer.statement();
        assertEquals(18.0, customer.totalAmount(), DELTA);
        assertEquals(4, customer.earnedFrequentRenterPoints());
    }

    @Test
    public void testSingleChildrenStatementTotals() {
        customer.addRental(new Rental(childrenMovie1, 3));
        customer.addRental(new Rental(childrenMovie1, 4));
        customer.statement();
        assertEquals(4.5, customer.totalAmount(), DELTA);
        assertEquals(2, customer.earnedFrequentRenterPoints());
    }

    @Test
    public void testMultipleRegularStatementTotals() {
        customer.addRental(new Rental(regularMovie1, 1));
        customer.addRental(new Rental(regularMovie2, 2));
        customer.addRental(new Rental(regularMovie3, 3));
        customer.statement();
        assertEquals(7.5, customer.totalAmount(), DELTA);
        assertEquals(3, customer.earnedFrequentRenterPoints());
    }

    @Test
    public void testMultipleRegularStatementFormat() {
        customer.addRental(new Rental(regularMovie1, 1));
        customer.addRental(new Rental(regularMovie2, 2));
        customer.addRental(new Rental(regularMovie3, 3));
        assertEquals(
                "Rental Record for Fred\n\t" +
                        "Plan 9 from Outer Space\t2.0\n\t" +
                        "8 1/2\t2.0\n\t" +
                        "Eraserhead\t3.5\n" +
                        "You owed 7.5\n" +
                        "You earned 3 frequent renter points\n",
                customer.statement());
    }
}