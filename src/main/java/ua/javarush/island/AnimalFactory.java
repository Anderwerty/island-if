package ua.javarush.island;

import ua.javarush.island.domain.animal.Animal;
import ua.javarush.island.domain.animal.Duck;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public final class AnimalFactory {

    private AnimalFactory() {
    }

    private static final Supplier<Animal> ANIMAL_NOT_FOUND_SUPPLIER = () -> {
        throw new IllegalArgumentException("<add your message>");
    };
    private static final Map<Class<? extends Animal>, Supplier<? extends Animal>> CLASS_TO_INSTANCE_SUPPLIER = new HashMap<>();

    static {
        CLASS_TO_INSTANCE_SUPPLIER.put(Duck.class, Duck::new);
        // add for other animals
    }

    public static Animal createAnimal(Class<? extends Animal> aClass) {
        return CLASS_TO_INSTANCE_SUPPLIER.getOrDefault(aClass, ANIMAL_NOT_FOUND_SUPPLIER).get();
    }
}
