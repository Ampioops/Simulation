package Entity;

import Simulation.*;

import java.util.List;

public class Herbivore extends Creature {

    public Herbivore(Coordinates coordinates, Integer speed, Integer HP) {
        super(coordinates, speed, HP);
    }

    @Override
    public void makeMove() {
        List <Coordinates> path = PathFinder.calculatePath(getCoordinates(), getClass());
        if (!path.isEmpty()) {
            path.removeFirst();
            Simulation.deleteEntity(this);

            if (path.size() <= speed) {
                setCoordinates(path.getLast());
                Simulation.setEntity(this, path.getLast());
            } else {
                setCoordinates(path.get(speed - 1));
                Simulation.setEntity(this, path.get(speed - 1));
            }
        }
    }
}
