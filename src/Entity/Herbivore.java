package Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Herbivore extends Creature {

    public Herbivore(Coordinates coordinates, Integer speed, Integer HP) {
        super(coordinates, speed, HP);
    }

    @Override
    public void makeMove(Map<Coordinates, Entity> entities) {
        System.out.println(PathFinder.calculatePath(getCoordinates(), getClass()));
    }
}
