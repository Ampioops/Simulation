package Entity;

import Action.HerbivoreGenerator;
import Simulation.*;

import java.util.List;
import java.util.NoSuchElementException;

public class Predator extends Creature {
    Integer ATK;

    public Predator(Integer speed, Integer HP, Integer ATK) {
        super(speed, HP);
        this.ATK = ATK;
    }

    @Override
    public void makeMove(Coordinates startCoordinates, MapClass map) {
        List<Coordinates> path = PathFinder.calculatePath(map, startCoordinates, getClass());
        Coordinates targetCoordinates;
        try {
            targetCoordinates = path.getLast();

        } catch (NoSuchElementException e) {
            herbivoreGenerator.create(map);
            return;
        }
        Herbivore target = (Herbivore) map.getEntity(targetCoordinates);
        if (!path.isEmpty() && path.size() > 1) {
            if (path.size() <= getSpeed()) {
                if (target.getHP() > ATK) {
                    target.attackedByPred(ATK);
                    map.delete(startCoordinates);
                    map.add(path.get(path.size() - 2), this);
                } else {
                    map.delete(startCoordinates);
                    map.delete(targetCoordinates);
                    map.add(targetCoordinates, this);
                }
            } else {
                map.delete(startCoordinates);
                map.add(path.get(getSpeed() - 1), this);
            }
            moved();
        }
    }
}
