package Action;

import Entity.Coordinates;
import Entity.Grass;
import Entity.Rock;
import Simulation.MapClass;

public class GrassGenerator extends EntityGenerator{
    @Override
    public void create(MapClass map) {
        double spawnRate = (double) (map.getColumn() * map.getRow()) * 7 / 100;

        for (int rate = map.countOfExactEntity(Grass.class); rate < spawnRate;) {
            Coordinates coordinates = generateRandCoordinates(map.getRow(), map.getColumn());

            if(checkIfCoordsEmpty(map, coordinates)) {
                map.add(coordinates, new Grass());
                rate++;
            }

        }
    }
}
