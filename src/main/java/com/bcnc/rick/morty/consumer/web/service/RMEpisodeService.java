package com.bcnc.rick.morty.consumer.web.service;

import com.rickandmortyapi.Episode;
import org.springframework.stereotype.Service;

@Service
public class RMEpisodeService {

    public Episode getEpisodeById(int id) {
        Episode episode = new Episode();
        return episode.get(id).toArray(new Episode[0])[0];
    }
}
