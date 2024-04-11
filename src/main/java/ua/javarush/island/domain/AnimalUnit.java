package ua.javarush.island.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AnimalUnit {

    private final int weight;
    private final double foodWeight;
    private final int maxStep;
    private final int maxAnimalNumberPerArea;

    @JsonCreator
    public AnimalUnit(@JsonProperty("weight") int weight,
                      @JsonProperty("foodWeight") double foodWeight,
                      @JsonProperty("maxStep") int maxStep,
                      @JsonProperty("maxAnimalNumberPerArea") int maxAnimalNumberPerArea) {

        System.out.println("constructor Animal unit");
        this.weight = weight;
        this.foodWeight = foodWeight;
        this.maxStep = maxStep;
        this.maxAnimalNumberPerArea = maxAnimalNumberPerArea;
    }

    public int getWeight() {
        return weight;
    }

    public double getFoodWeight() {
        return foodWeight;
    }

    public int getMaxStep() {
        return maxStep;
    }

    public int getMaxAnimalNumberPerArea() {
        return maxAnimalNumberPerArea;
    }

    @Override
    public String toString() {
        return "AnimalUnit{" +
                "weight=" + weight +
                ", foodWeight=" + foodWeight +
                ", maxStep=" + maxStep +
                ", maxAnimalNumberPerArea=" + maxAnimalNumberPerArea +
                '}';
    }
}
