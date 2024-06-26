package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CheckOnDepartureBeforeNow implements Filter {

    @Override

    public List<Flight> filter(List<Flight> list) {

        List<Flight> flightList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            ArrayList<Segment> listSegment = (ArrayList<Segment>) list.get(i).getSegments();
            int size1 = listSegment.size();
            int j = 0;
            while (j < size1 && (listSegment.get(j).getDepartureDate()).isAfter(LocalDateTime.now())) {
                j++;
            }

            if (j==size1) {

                flightList.add(list.get(i));
            }
        }
        return flightList;

    }

}
