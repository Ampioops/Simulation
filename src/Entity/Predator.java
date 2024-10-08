package Entity;

import Simulation.*;

import java.util.List;

public class Predator extends Creature {
    Integer ATK;

    public Predator(Integer speed, Integer HP, Integer ATK) {
        super(speed, HP);
        this.ATK = ATK;
    }

    @Override
    public void makeMove(Coordinates coordinates, MapClass map) {
        List<Coordinates> path = PathFinder.calculatePath(map, coordinates, getClass());

        if(!path.isEmpty()) {
            if (path.size() <= speed) {
                map.del(path.getLast());
            }
            map.del(path.getFirst());
            map.add(path.getLast(), this);
            moved();
        }
    }
}
