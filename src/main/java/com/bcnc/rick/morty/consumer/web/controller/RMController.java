package com.bcnc.rick.morty.consumer.web.controller;

import com.bcnc.rick.morty.consumer.web.entity.RMCharacterData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RMController {

    @GetMapping("/search-character-appearance")
    public RMCharacterData getRickAndMorty(@RequestParam(name = "name") String name) {
        return new RMCharacterData();
    }
}
