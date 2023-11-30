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

/***
 * This class is the service layer of the application.
 * Its pourpose is to receive the request from the controller, fetch all the data necessary
 * from the various services, build the correct Object to respond and return it to the controller.
 */
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
        if(characters.length == 0){
            return rmCharacterDataList;
        }
        for (Character character : characters) {
            RMCharacterData rmCharacterData = new RMCharacterData();
            rmCharacterData.setName(character.getName());
            List<Episode> episodeList = character.getEpisodes();
            if(!episodeList.isEmpty()){
                Integer[] episodeIds = episodeList.stream().map(
                        Episode::getId
                ).filter(
                        (id) -> id > -1
                ).toArray(Integer[]::new);
                if(episodeIds.length > 0){
                    Episode[] episodes = rmEpisodeService.getEpisodesByIds(episodeIds);
                    rmCharacterData.setEpisodes(Arrays.stream(episodes).map(
                            Episode::getName
                    ).toArray(String[]::new));
                }
            }
            Integer locationId = character.getOriginLocation().getId();
            if(locationId > -1){
                Location location = rmLocationService.getLocationById(locationId);
                rmCharacterData.setFirstAppearance(
                        location.getCreated().format(DateTimeFormatter.ISO_LOCAL_DATE));
                rmCharacterDataList.add(rmCharacterData);
            }
        }
        return rmCharacterDataList;
    }
}
