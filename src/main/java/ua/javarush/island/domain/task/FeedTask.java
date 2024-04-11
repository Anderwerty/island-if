package ua.javarush.island.domain.task;

import ua.javarush.island.domain.island.Area;

public class FeedTask implements Runnable {
    private final Area area;

    public FeedTask(Area area) {
        this.area = area;
    }

    @Override
    public void run() {
        area.processAnimalFeeding();
    }
}

