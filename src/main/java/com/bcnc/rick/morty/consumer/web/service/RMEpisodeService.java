package com.bcnc.rick.morty.consumer.web.service;

import com.rickandmortyapi.Episode;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RMEpisodeService {

    public Episode[] getEpisodesByIds(Integer... ids) {
        List<Episode> episodes = new ArrayList<>();
        for (Integer id : ids) {
            Episode episode = new Episode(id);
            episodes.add(episode.refresh());
        }
        return episodes.toArray(new Episode[0]);
    }
}
