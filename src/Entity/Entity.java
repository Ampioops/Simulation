package Entity;

import java.util.HashMap;
import java.util.Map;

public class Entity {
    private Coordinates coordinates;

    public Entity(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "coordinates=" + coordinates +
                '}';
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}
