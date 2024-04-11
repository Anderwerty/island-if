package ua.javarush.island.domain;

public class Coordinates {

    private final int x;
    private final int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Coordinates nextCoordinates(Direction direction) {
        return new Coordinates(this.x + direction.getDeltaX(), this.y + direction.getDeltaY());
    }
}
