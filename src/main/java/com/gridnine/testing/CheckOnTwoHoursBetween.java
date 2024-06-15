package com.gridnine.testing;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CheckOnTwoHoursBetween implements Filter {
    @Override
    public List<Flight> filter(List<Flight> list) {
        List<Flight> flights = new ArrayList<>();
        boolean b;
        for (int i = 0; i < list.size(); i++) {
            b=true;
            ArrayList<Segment> listSegment = (ArrayList<Segment>) list.get(i).getSegments();
            for (int j = 0; j < listSegment.size() - 1; j++) {
                if (ChronoUnit.HOURS.between(listSegment.get(j).getArrivalDate(),
                        listSegment.get(j + 1).getDepartureDate()) > 2) {
                    b = false; break;
                }
            }
            if(b){ Flight flight = new Flight(listSegment);
                flights.add(flight);
           }
        }
        return flights;

    }
}