package com.gridnine.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CheckOnTwoHoursBetweenTest {
    private final CheckOnTwoHoursBetween check = new CheckOnTwoHoursBetween();
    LocalDateTime now = LocalDateTime.now();
  Segment segment1 = new Segment(now,now.plusHours(1));
  Segment segment2 = new Segment(now.plusHours(2),now.plusHours(3));
  Segment segment3 = new Segment(now.plusHours(4),now.plusHours(5));
  Segment segment4 = new Segment(now.plusHours(6),now.plusHours(7));
  List<Segment> list1 = new ArrayList<>(List.of(segment1,segment2));
  List<Segment> list2 = new ArrayList<>(List.of(segment1,segment4));
  List<Segment> list3 = new ArrayList<>(List.of(segment1,segment2,segment3,segment4));
  List<Segment> list4 = new ArrayList<>(List.of(segment3,segment4));
  Flight flight1 = new Flight(list1);
  Flight flight2 = new Flight(list2);
  Flight flight3 = new Flight(list3);
  Flight flight4 = new Flight(list4);
  List<Flight> flightList1 = new ArrayList<>(List.of(flight1,flight2,flight3,flight4));
  List<Flight> flightList2 = new ArrayList<>(List.of(flight1,flight4));
  @Test
  public void filterTest(){
      Assertions.assertEquals(check.filter(flightList1),flightList2);
  }
}
