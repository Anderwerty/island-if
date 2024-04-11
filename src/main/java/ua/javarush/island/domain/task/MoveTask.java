package ua.javarush.island.domain.task;

import ua.javarush.island.domain.animal.Animal;
import ua.javarush.island.domain.island.Area;

public class MoveTask implements Runnable {
    private final Area from;
    private final Area to;

    private final Animal animal;

    public MoveTask(Area from, Area to, Animal animal) {
        this.from = from;
        this.to = to;
        this.animal = animal;
    }

    @Override
    public void run() {

        if (from == to) { // or check by coordinates
            return;
        }

        if (to.isPossibleToAddAnimal(animal)) {
            //it is possible to get deadlock ??
            synchronized (to.lock) {
                synchronized (from.lock) {
                    if (to.isPossibleToAddAnimal(animal)) {
                        from.removeAnimal(animal);
                        to.addAnimal(animal);
                    }
                }
            }
        }

    }
}
