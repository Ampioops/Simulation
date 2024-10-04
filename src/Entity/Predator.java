package Entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Predator extends Creature {
    Integer ATK;

    public Predator(Coordinates coordinates, Integer speed, Integer HP, Integer ATK) {
        super(coordinates, speed, HP);
        this.ATK = ATK;
    }

    @Override
    public void makeMove() {

        List<Coordinates> path = PathFinder.calculatePath(getCoordinates(),getClass());

        System.out.println(path);

    }
}
