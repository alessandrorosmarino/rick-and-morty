package com.bcnc.rick.morty.consumer.web.service;

import com.rickandmortyapi.Character;
import org.springframework.stereotype.Service;

@Service
public class RMCharacterService {

    public Character[] getCharacterByName(String name) {
        Character character = new Character();
        return character.withName(name).filter().toArray(new Character[0]);
    }



}
