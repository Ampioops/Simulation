package Action;

import Entity.Coordinates;
import Simulation.MapClass;

public abstract class Generator {

    public static Coordinates generateRandCoordinates(Integer rows, Integer cols) {
        int row = (int) (Math.random() * rows);
        int col = (int) (Math.random() * cols);
        return new Coordinates(row, col);
    }

    public boolean checkIfCoordsEmpty(MapClass map, Coordinates coords) {
        return !map.contains(coords);
    }
}
