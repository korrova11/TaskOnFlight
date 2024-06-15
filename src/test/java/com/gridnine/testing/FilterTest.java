package com.gridnine.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FilterTest {
    private final CheckOnArrivalBeforeDeparture check1 = new CheckOnArrivalBeforeDeparture();



    LocalDateTime now = LocalDateTime.now();
    LocalDateTime nowPlus1 = LocalDateTime.now().plusHours(1);
    LocalDateTime nowMinus1 = LocalDateTime.now().minusHours(1);
    LocalDateTime nowPlus2 = LocalDateTime.now().plusHours(2);
    Segment segment1 = new Segment(now,nowPlus1);
    Segment segment2 = new Segment(now,nowPlus2);
    Segment segment3 = new Segment(now,nowMinus1);
    List<Segment> list1 = new ArrayList<>(List.of(segment1,segment2,segment3));
    List<Segment> list2 = new ArrayList<>(List.of(segment1,segment2));
    Flight flight2 = new Flight(list2);
    Flight flight1 = new Flight(list1);

    List<Flight> flightList1 = new ArrayList<>(List.of(flight1,flight2));
    List<Flight> flightList2 = new ArrayList<>(List.of(flight2));

    @Test
    public void filter1(){

        Assertions.assertTrue(check1.filter(flightList1).size()==1);

    }
}
