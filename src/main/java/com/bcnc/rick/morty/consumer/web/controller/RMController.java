package com.bcnc.rick.morty.consumer.web.controller;

import com.bcnc.rick.morty.consumer.exception.NoRMCharacterFoundException;
import com.bcnc.rick.morty.consumer.web.entity.RMCharacterData;
import com.bcnc.rick.morty.consumer.web.service.RMConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/***
 * This class is the controller of the application.
 * Its pourpose is to receive the request from the client ,send it to the service layer and
 * return the response to the client accordingly.
 */
@RestController
public class RMController {

    private RMConsumerService rmConsumerService;

    @Autowired
    public RMController(RMConsumerService rmConsumerService) {
        this.rmConsumerService = rmConsumerService;
    }

    @GetMapping("/search-character-appearance")
    public List<RMCharacterData> getRickAndMorty(@RequestParam(name = "name") String name) {
        List<RMCharacterData> rmCharacterDataList = rmConsumerService.getCharacterForConsumerByName(name);
        if (rmCharacterDataList.isEmpty()) {
            throw new NoRMCharacterFoundException("No character found with name: " + name);
        }
        return rmCharacterDataList;
    }
}
