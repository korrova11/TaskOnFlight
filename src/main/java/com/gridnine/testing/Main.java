package com.gridnine.testing;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();
        System.out.println( flights);
        Filter filter1 = new CheckOnArrivalBeforeDeparture();
        System.out.println(filter1.filter(flights));
        Filter filter2 = new CheckOnDepartureBeforeNow();
        System.out.println(filter2.filter(flights));
        Filter filter3 = new CheckOnTwoHoursBetween();
        System.out.println(filter3.filter(flights));
    }
}