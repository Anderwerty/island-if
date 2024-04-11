package ua.javarush.island.domain.animal;

import ua.javarush.island.domain.AnimalUnit;
import ua.javarush.island.domain.Properties;
import ua.javarush.island.domain.island.Area;
import ua.javarush.island.util.AnimalPropertyUtil;

@Properties(filename = "duck.json")
public class Duck extends Herbivorous {

    private static final AnimalUnit ANIMAL_UNIT = AnimalPropertyUtil.parse(Duck.class);

    @Override
    public void eat(Area area) {

    }

    @Override
    public Duck reproduce() {
        boolean condition = true;
        return condition ? new Duck() : null;
    }

    @Override
    public AnimalUnit getAnimalUnit() {
        return ANIMAL_UNIT;
    }
}
