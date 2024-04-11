package ua.javarush.island.domain.animal;

import ua.javarush.island.domain.AnimalUnit;
import ua.javarush.island.domain.Direction;
import ua.javarush.island.domain.island.Area;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public abstract class Animal {
    private static final Map<Integer, Direction> CHOOSE_TO_DIRECTION;

    static {
        HashMap<Integer, Direction> chooseToDirection = new HashMap<>();
        chooseToDirection.put(1, Direction.RIGHT);
        chooseToDirection.put(2, Direction.LEFT);
        chooseToDirection.put(3, Direction.UP);
        chooseToDirection.put(4, Direction.DOWN);

        CHOOSE_TO_DIRECTION = Collections.unmodifiableMap(chooseToDirection);

    }

    protected int healthPoint;
    private final String id;
    protected final Lock lock;

    protected Animal() {
        this.healthPoint = 100;
        this.id = UUID.randomUUID().toString();
        this.lock = new ReentrantLock();
    }

    public abstract void eat(Area area);

    public Direction chooseDirection() {
        ThreadLocalRandom random = ThreadLocalRandom.current();

        return CHOOSE_TO_DIRECTION.get(random.nextInt(1, 5));
    }

    public abstract Animal reproduce();

    public abstract AnimalUnit getAnimalUnit();

    public boolean isDead() {
        return healthPoint <= 0;
    }

    public Lock getLock() {
        return lock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Animal animal = (Animal) o;
        return Objects.equals(id, animal.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
