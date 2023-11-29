package com.bcnc.rick.morty.consumer.web.service;

import com.rickandmortyapi.Episode;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/***
 * This class is the service that will be used to consume the Rick and Morty API Episode endpoint.
 */
@Service
public class RMEpisodeService {

    protected Episode[] getEpisodesByIds(Integer... ids) {
        List<Episode> episodes = new ArrayList<>();
        for (Integer id : ids) {
            Episode episode = new Episode(id);
            episodes.add(episode.refresh());
        }
        return episodes.toArray(new Episode[0]);
    }
}
