package ua.javarush.island;

import com.fasterxml.jackson.core.JsonProcessingException;
import ua.javarush.island.domain.animal.Duck;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        System.out.println("=====================================");

        Duck duck1 = new Duck();
        Duck duck2 = new Duck();

        System.out.println(duck1.getAnimalUnit());


        System.out.println(UUID.randomUUID().toString());

        ThreadLocalRandom random = ThreadLocalRandom.current();
        for (int i = 0; i < 20; i++) {
            System.out.println(random.nextInt(1, 5));

        }


    }
}