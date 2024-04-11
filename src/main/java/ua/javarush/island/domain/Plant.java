package ua.javarush.island.domain;

import java.util.UUID;


public class Plant {

    private final String id = UUID.randomUUID().toString();

    public String getId() {
        return id;
    }

    public Plant reproduce() {
        boolean isReproduce = true;
        return isReproduce ? new Plant() : null;
    }
}
