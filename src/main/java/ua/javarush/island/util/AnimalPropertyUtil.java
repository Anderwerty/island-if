package ua.javarush.island.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ua.javarush.island.domain.AnimalUnit;
import ua.javarush.island.domain.Properties;
import ua.javarush.island.domain.animal.Animal;

import java.io.IOException;

public final class AnimalPropertyUtil {
    private AnimalPropertyUtil() {
    }

    public static AnimalUnit parse(Class<? extends Animal> aClass) {
        if (aClass.isAnnotationPresent(Properties.class)) {
            Properties annotation = aClass.getAnnotation(Properties.class);
            String filename = annotation.filename();
            String json = readFromFile(filename);

            try {
                return new ObjectMapper().readValue(json, AnimalUnit.class);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }

        return null;
    }

    private static String readFromFile(String filename){
        try {
            return new String(AnimalPropertyUtil.class.getClassLoader().getResourceAsStream(filename).readAllBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
