package ua.javarush.island.domain.animal;

import ua.javarush.island.domain.AnimalUnit;
import ua.javarush.island.domain.island.Area;

public class Dog extends Herbivorous{
    @Override
    public void eat(Area area) {

    }

    @Override
    public Animal reproduce() {
        return null;
    }

    @Override
    public AnimalUnit getAnimalUnit() {
        return null;
    }
}
