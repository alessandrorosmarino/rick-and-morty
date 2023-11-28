package com.bcnc.rick.morty.consumer.web.service;

import com.rickandmortyapi.Episode;
import org.springframework.stereotype.Service;

@Service
public class RMEpisodeService {

    public Episode[] getEpisodesByIds(Integer... ids) {
        Episode episode = new Episode();
        return episode.get(ids).toArray(new Episode[0]);
    }
}
