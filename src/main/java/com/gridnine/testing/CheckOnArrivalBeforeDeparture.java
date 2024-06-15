package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CheckOnArrivalBeforeDeparture implements Filter {
    public CheckOnArrivalBeforeDeparture() {
    }

    /**
     * метод исключает из Полета сегменты, у которых дата прилета раньше даты вылета
     * @param list
     * @return
     */
    @Override
    public List<Flight> filter(List<Flight> list) {


        List<Flight> flightList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            ArrayList<Segment> listSegment = (ArrayList<Segment>) list.get(i).getSegments();
            int size = listSegment.size();
            ArrayList<Segment> listSegment1= (ArrayList<Segment>) listSegment.stream()
                    .filter(s ->
                            s.getDepartureDate().isBefore(s.getArrivalDate()))
                    .collect(Collectors.toList());
            if (listSegment1.size()==size) {
                Flight flight = new Flight(listSegment);
                flightList.add(flight);
            }}
        return flightList;

    }


}
