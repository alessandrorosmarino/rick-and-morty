package com.bcnc.rick.morty.consumer.web.service;

import com.bcnc.rick.morty.consumer.web.entity.RMCharacterData;
import com.rickandmortyapi.Character;
import com.rickandmortyapi.Episode;
import com.rickandmortyapi.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.threeten.bp.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class RMConsumerService {

    private RMCharacterService rmCharacterService;
    private RMEpisodeService rmEpisodeService;
    private RMLocationService rmLocationService;

    @Autowired
    public RMConsumerService(RMCharacterService rmCharacterService, RMEpisodeService rmEpisodeService,
                             RMLocationService rmLocationService) {
        this.rmCharacterService = rmCharacterService;
        this.rmEpisodeService = rmEpisodeService;
        this.rmLocationService = rmLocationService;
    }

    public List<RMCharacterData> getCharacterForConsumerByName(String name) {
        List<RMCharacterData> rmCharacterDataList = new ArrayList<>();
        Character[] characters = rmCharacterService.getCharacterByName(name);
        for (Character character : characters) {
            RMCharacterData rmCharacterData = new RMCharacterData();
            rmCharacterData.setName(character.getName());
            Integer[] episodeIds = character.getEpisodes().stream().map(
                    Episode::getId
            ).toArray(Integer[]::new);
            Episode[] episodes = rmEpisodeService.getEpisodesByIds(episodeIds);
            rmCharacterData.setEpisodes(Arrays.stream(episodes).map(
                    Episode::getName
            ).toArray(String[]::new));
            Location location = rmLocationService.getLocationById(character.getOriginLocation().getId());
            rmCharacterData.setFirstAppearance(
                    location.getCreated().format(DateTimeFormatter.ISO_LOCAL_DATE));
            rmCharacterDataList.add(rmCharacterData);
        }
        return rmCharacterDataList;
    }
}
