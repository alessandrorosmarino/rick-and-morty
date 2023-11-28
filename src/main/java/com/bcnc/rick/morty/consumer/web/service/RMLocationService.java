package com.bcnc.rick.morty.consumer.web.service;

import com.rickandmortyapi.Location;
import org.springframework.stereotype.Service;

@Service
public class RMLocationService {

    public Location[] getLocationByIds(Integer... ids) {
        Location location = new Location();
        return location.get(ids).toArray(new Location[0]);
    }
}
