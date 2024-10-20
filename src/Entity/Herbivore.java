package Entity;

import Action.GrassGenerator;
import Simulation.MapClass;

import java.util.List;

public class Herbivore extends Creature {

    GrassGenerator grassGenerator = new GrassGenerator();
    boolean ateGrass = false;

    public Herbivore(Integer speed, Integer HP) {
        super(speed, HP);
    }

    @Override
    public void makeMove(Coordinates coordinates, MapClass map) {
        List<Coordinates> path = PathFinder.calculatePath(map, coordinates, getClass());

        if(!path.isEmpty()) {
            if (path.size() <= getSpeed()) {
                map.delete(path.getLast());
                ateGrass = true;
            }
            map.delete(path.getFirst());
            map.add(path.getLast(), this);
            moved();

            if (ateGrass) {
                newGrass(map);
                ateGrass = false;
            }
        }
    }

    public void attackedByPred (int ATK){
        setHP(getHP() - ATK);
    }

    private void newGrass(MapClass map){
        grassGenerator.createOneInstance(map);
    }
}
