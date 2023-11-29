package com.bcnc.rick.morty.consumer.web.service;

import com.rickandmortyapi.Location;
import org.springframework.stereotype.Service;

@Service
public class RMLocationService {

    public Location getLocationById(Integer id) {
        Location location = new Location(id);
        return location.refresh();
    }
}
