package com.bcnc.rick.morty.consumer.web.service;

import com.rickandmortyapi.Location;
import org.springframework.stereotype.Service;

/***
 * This class is the service that will be used to consume the Rick and Morty API Location endpoint.
 */
@Service
public class RMLocationService {

    protected Location getLocationById(Integer id) {
        Location location = new Location(id);
        return location.refresh();
    }
}
