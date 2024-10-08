package Simulation;

import Entity.Coordinates;
import Entity.Creature;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Simulation{
    Integer counter = 0;
    Renderer renderer;
    public MapClass map = new MapClass(10,10);

    public void startSimulation() {
        renderer = new Renderer();
        renderer.render(map);
        nextTurn();

        System.out.println();
        renderer.render(map);

    }

    public void nextTurn() {

        Set<Coordinates> coordSet = new HashSet<>(map.getCoordinatesSet());

        for(Coordinates coordinates : coordSet) {
            if (map.getEntity(coordinates) instanceof Creature && ((Creature) map.getEntity(coordinates)).canMove()) {
                ((Creature) map.getEntity(coordinates)).makeMove(coordinates,map);
            }
        }
    }

    public void pauseSimulation() {

    }

}
