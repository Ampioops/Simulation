package Action;

import Entity.Coordinates;

public abstract class Generator {

    public static Coordinates generateRandCoordinates(Integer rows, Integer cols) {
        int row = (int) (Math.random() * rows);
        int col = (int) (Math.random() * cols);
        return new Coordinates(row, col);
    }
}
