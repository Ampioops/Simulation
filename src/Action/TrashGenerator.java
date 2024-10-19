package Action;

import Entity.Coordinates;
import Entity.Predator;
import Entity.Rock;
import Entity.Tree;
import Simulation.MapClass;
import Simulation.Simulation;

import java.util.Map;

public class TrashGenerator extends EntityGenerator{
    MapClass map = Simulation.map;
    double trashSpawnRate = (double) (map.getColumn() * map.getRow()) * 15 / 100;

    @Override
    public void create(MapClass map) {

        for (int rate = (map.countOfExactEntity(Rock.class) + map.countOfExactEntity(Tree.class)); rate < trashSpawnRate; ) {
            Coordinates coordinates = generateRandCoordinates(map.getRow(), map.getColumn());

            if (checkIfCoordsEmpty(map, coordinates)) {
                if((int)(Math.random()*2) == 0) {
                    map.add(coordinates, new Rock());
                }else {
                    map.add(coordinates, new Tree());
                }
                rate++;
            }

        }
    }
}
