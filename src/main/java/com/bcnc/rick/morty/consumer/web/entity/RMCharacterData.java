package com.bcnc.rick.morty.consumer.web.entity;

import java.util.Arrays;

/***
 * This Object has been created to store the data from the API
 * as the Rick and Morty API don't provide an object with such
 * structure.
 */
public class RMCharacterData {

    private String name;
    private String[] episodes;
    private String firstAppearance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getEpisodes() {
        return episodes;
    }

    public void setEpisodes(String[] episodes) {
        this.episodes = episodes;
    }

    public String getFirstAppearance() {
        return firstAppearance;
    }

    public void setFirstAppearance(String firstAppearance) {
        this.firstAppearance = firstAppearance;
    }

    @Override
    public String toString() {
        return "RMCharacterData{" +
                "name='" + name + '\'' +
                ", episodes=" + Arrays.toString(episodes) +
                ", firstAppearance='" + firstAppearance + '\'' +
                '}';
    }
}
