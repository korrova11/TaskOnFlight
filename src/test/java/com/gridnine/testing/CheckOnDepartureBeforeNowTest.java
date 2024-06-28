package com.gridnine.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CheckOnDepartureBeforeNowTest {
    private final CheckOnDepartureBeforeNow check = new CheckOnDepartureBeforeNow();
    LocalDateTime now = LocalDateTime.now();
    Segment segment1 = new Segment(now.plusHours(1), now.plusHours(2));
    Segment segment2 = new Segment(now.minusHours(1), now.plusHours(1));
    Segment segment3 = new Segment(now.minusHours(2), now.plusHours(1));
    Segment segment4 = new Segment(now.plusHours(1), now.plusHours(3));
    Segment segment5 = new Segment(now.plusHours(1), now.plusHours(4));
    List<Segment> segments1 = new ArrayList<>(List.of(segment1));
    List<Segment> segments2 = new ArrayList<>(List.of(segment1, segment2));
    List<Segment> segments3 = new ArrayList<>(List.of(segment1, segment4));
    List<Segment> segments4 = new ArrayList<>(List.of(segment1, segment3, segment4));
    Flight flight1 = new Flight(segments1);
    Flight flight2 = new Flight(segments2);
    Flight flight3 = new Flight(segments3);
    Flight flight4 = new Flight(segments4);
    List<Flight> flights = new ArrayList<>(List.of(flight1,flight2,flight3,flight4));
    List<Flight> flightExpected = new ArrayList<>(List.of(flight1,flight3));
    @Test
    public void filter(){
        Assertions.assertEquals(check.filter(flights),flightExpected);
    }


}
