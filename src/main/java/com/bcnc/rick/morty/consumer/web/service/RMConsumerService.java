package com.bcnc.rick.morty.consumer.web.service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.rickandmortyapi.Character;
import com.rickandmortyapi.Episode;
import com.rickandmortyapi.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.threeten.bp.format.DateTimeFormatter;

@Service
public class RMConsumerService {

    private RMCharacterService rmCharacterService;
    private RMEpisodeService rmEpisodeService;

    @Autowired
    public RMConsumerService(RMCharacterService rmCharacterService, RMEpisodeService rmEpisodeService) {
        this.rmCharacterService = rmCharacterService;
        this.rmEpisodeService = rmEpisodeService;
    }

    public JsonArray getCharacterForConsumerByName(String name) {
        JsonArray characterJsonArray = new JsonArray();
        Character[] characters = rmCharacterService.getCharacterByName(name);
        for (Character character : characters) {
            JsonObject characterJsonObject = new JsonObject();
            characterJsonObject.addProperty("name",character.getName());
            Integer[] episodeIds = character.getEpisodes().stream().map(
                    Episode::getId
            ).toArray(Integer[]::new);
            Episode[] episodes = rmEpisodeService.getEpisodesByIds(episodeIds);
            JsonArray episodeArray = new JsonArray();
            for (Episode episode : episodes) {
                episodeArray.add(episode.getName());
            }
            characterJsonObject.add("episodes",episodeArray);
            Location location = character.getOriginLocation();
            characterJsonObject.addProperty("first_appearance",
                    location.getCreated().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
            characterJsonArray.add(characterJsonObject);
        }
        return characterJsonArray;
    }
}
