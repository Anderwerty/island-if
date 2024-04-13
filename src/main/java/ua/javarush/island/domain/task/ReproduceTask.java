package ua.javarush.island.domain.task;

import ua.javarush.island.domain.island.Area;

public class ReproduceTask implements Runnable{

    private final Area area;

    public ReproduceTask(Area area) {
        this.area = area;
    }

    @Override
    public void run() {
        area.reproduce();
    }
}
