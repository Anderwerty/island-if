package ua.javarush.island.domain.task;

import ua.javarush.island.domain.animal.Animal;
import ua.javarush.island.domain.island.Area;

import java.util.concurrent.locks.Lock;

public class MoveTask implements Runnable {
    private final Area from;
    private final Area to;

    private final Animal animal;

    public MoveTask(Area from, Area to, Animal animal) {
        this.from = from;
        this.to = to;
        this.animal = animal;
    }

//    @Override
//    public void run() {
//
//        if (from == to) { // or check by coordinates
//            return;
//        }
//
//        if (to.isPossibleToAddAnimal(animal)) {
//            //it is possible to get deadlock ??
//            synchronized (to.getLock(animal.getClass())) {
//                synchronized (from.getLock(animal.getClass())) {
//                    if (to.isPossibleToAddAnimal(animal)) {
//                        from.removeAnimal(animal);
//                        //.....
//                        to.addAnimal(animal);
//                    }
//                }
//            }
//        }
//
//    }


    @Override
    public void run() {

        if (from == to) { // or check by coordinates
            return;
        }

        if (to.isPossibleToAddAnimal(animal)) {
            Lock lockFrom = from.getLock(animal.getClass());
            Lock lockTo = to.getLock(animal.getClass());

            try{

                //tryLock not to get deadlock
                lockFrom.lock();
                lockTo.lock();
               if (to.isPossibleToAddAnimal(animal)) {
                from.removeAnimal(animal);
                to.addAnimal(animal);
               }
            } finally {
                lockTo.unlock();
                lockFrom.unlock();

            }

        }

    }
}
