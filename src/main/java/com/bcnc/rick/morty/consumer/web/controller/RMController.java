package com.bcnc.rick.morty.consumer.web.controller;

import com.bcnc.rick.morty.consumer.web.entity.RMCharacterData;
import com.bcnc.rick.morty.consumer.web.service.RMConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RMController {

    private RMConsumerService rmConsumerService;

    @Autowired
    public RMController(RMConsumerService rmConsumerService) {
        this.rmConsumerService = rmConsumerService;
    }

    @GetMapping("/search-character-appearance")
    public List<RMCharacterData> getRickAndMorty(@RequestParam(name = "name") String name) {
        return rmConsumerService.getCharacterForConsumerByName(name);
    }
}
