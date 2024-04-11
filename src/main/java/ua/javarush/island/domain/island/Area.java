package ua.javarush.island.domain.island;

import ua.javarush.island.AnimalFactory;
import ua.javarush.island.domain.Coordinates;
import ua.javarush.island.domain.Plant;
import ua.javarush.island.domain.animal.Animal;
import ua.javarush.island.domain.animal.Duck;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;

public class Area {

    private static final int PLANT_MAX_NUMBER = 10;

    private static final Map<Class<? extends Animal>, Integer> CLASS_TO_NUMBER = new HashMap<>();

    static {
        CLASS_TO_NUMBER.put(Duck.class, 200);
    }

    private final Set<Plant> plants = new HashSet<>();
    private final Map<Class<? extends Animal>, Set<? extends Animal>> classToAnimals = new HashMap<>();
    private final Map<Class<? extends Animal>, Lock> classToLock = new HashMap<>();

    private final Lock plantLock = new ReentrantLock();


    public final Object lock = new Object();


    private final Coordinates coordinates;

    private Area(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public static Area initArea(Coordinates coordinates) {
        Area area = new Area(coordinates);
        initPlants(area);
        CLASS_TO_NUMBER.forEach((aClass, count) -> {
            int number = ThreadLocalRandom.current().nextInt(1, count + 1);
            Set<Animal> animals = new HashSet<>();
            for (int i = 0; i < number; i++) {
                animals.add(AnimalFactory.createAnimal(aClass));
            }
            area.classToAnimals.put(aClass, animals);
        });

        return area;
    }

    private static void initPlants(Area area) {
        int number = ThreadLocalRandom.current().nextInt(1, PLANT_MAX_NUMBER + 1);
        for (int i = 0; i < number; i++) {
            area.plants.add(new Plant());
        }
    }
//
//    public void addPlant() {
//        if (plants.size() <= PLANT_MAX_NUMBER) {
//            plants.add(new Plant());
//        }
//    }
//
//    public void removePlant(String id) {
//        plants.removeIf(plant -> plant.getId().equals(id));
//    }
//
//    public Lock getPlantLock() {
//        return plantLock;
//    }
//
//    public Lock getAnimalLock() {
//        return animalLock;
//    }


    public void processAnimalFeeding() {
        classToAnimals.forEach(((aClass, animals) -> {
            animals.forEach(animal -> {  // animal should not be dead
                animal.eat(this);
                //.....
            });
        }));
    }

    public void removeDeadItems() {
        classToAnimals.forEach((aClass, animals) -> animals.removeIf(Animal::isDead));
        // clean dead plants
    }


    public void reproduce() {
        List<Plant> newPlants = new ArrayList<>();

        plants.forEach(plant -> {
            Plant newPlant = plant.reproduce();
            if (newPlant != null) {
                newPlants.add(newPlant);
            }
        });

        // need to check limits
        // add just n first
        int n = 10;
        plants.addAll(newPlants.subList(0, n));
    }

    public void removeAnimal(Animal animal) {

    }

    public void addAnimal(Animal animal) {
    }

    public boolean isPossibleToAddAnimal(Animal animal) {
        return false;
    }
}
