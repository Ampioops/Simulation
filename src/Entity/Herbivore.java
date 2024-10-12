package Entity;

import Simulation.MapClass;

import java.util.List;

public class Herbivore extends Creature {

    public Herbivore(Integer speed, Integer HP) {
        super(speed, HP);
    }

    @Override
    public void makeMove(Coordinates coordinates, MapClass map) {
        List<Coordinates> path = PathFinder.calculatePath(map, coordinates, getClass());

        if(!path.isEmpty()) {
            if (path.size() <= getSpeed()) {
                map.delete(path.getLast());
            }
            map.delete(path.getFirst());
            map.add(path.getLast(), this);
            moved();
        }
    }

    public void attackedByPred (int ATK){
        setHP(getHP() - ATK);
    }
}
