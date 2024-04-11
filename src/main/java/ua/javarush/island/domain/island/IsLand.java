package ua.javarush.island.domain.island;

import ua.javarush.island.domain.Coordinates;
import ua.javarush.island.domain.task.FeedTask;

import java.util.ArrayList;
import java.util.List;

public class IsLand {

    private final Area[][] areas;
    private final int xSize;
    private final int ySize;

    public IsLand(int xSize, int ySize) {
        this.xSize = xSize;
        this.ySize = ySize;
        this.areas = initIsland(xSize, ySize);
    }

    private static Area[][] initIsland(int xSize, int ySize) {
        Area[][] areas = new Area[xSize][ySize];

        //TODO: several threads
        for (int i = 0; i < xSize; i++) {
            for (int j = 0; j < ySize; j++) {
                areas[i][j] = Area.initArea(new Coordinates(j, i));
            }
        }
        return areas;
    }


    public List<Runnable> provideFeedingTasks() {
        List<Runnable> tasks = new ArrayList<>();
        for (int i = 0; i < areas.length; i++) {
            for (int j = 0; j < areas[i].length; j++) {
                tasks.add(new FeedTask(areas[i][j]));
            }
        }

        return tasks;
    }

//    public List<Runnable> provideMoving

    private Area findAreaByCoordinates(Coordinates coordinates) {
        return areas[coordinates.getX()][coordinates.getY()];
    }

    private boolean isValidNextCoordinates(Coordinates coordinates) {
        return isValidCoordinate(coordinates.getX(), xSize) && isValidCoordinate(coordinates.getY(), ySize);
    }

    private boolean isValidCoordinate(int coordinate, int size) {
        return coordinate < size && coordinate >= 0;
    }

}
