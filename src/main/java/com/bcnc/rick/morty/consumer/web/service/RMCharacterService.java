package com.bcnc.rick.morty.consumer.web.service;

import com.rickandmortyapi.Character;
import org.springframework.stereotype.Service;

/***
 * This class is the service that will be used to consume the Rick and Morty API Character endpoint.
 */
@Service
public class RMCharacterService {

    protected Character[] getCharacterByName(String name) {
        Character character = new Character();
        return character.withName(name).filter().toArray(new Character[0]);
    }



}
