package Action;

import Entity.Coordinates;
import Entity.Grass;
import Entity.Herbivore;
import Entity.Rock;
import Simulation.MapClass;

public class GrassGenerator extends EntityGenerator{
    @Override
    public void create(MapClass map) {
        double spawnRate = (double) (map.getColumn() * map.getRow()) * 9 / 100;

        for (int rate = map.countOfExactEntity(Grass.class); rate < spawnRate;) {
            Coordinates coordinates = generateRandCoordinates(map.getRow(), map.getColumn());

            if(checkIfCoordsEmpty(map, coordinates)) {
                map.add(coordinates, new Grass());
                rate++;
            }

        }
    }

    public void createOneInstance(MapClass map){
        Coordinates coordinates = generateRandCoordinates(map.getRow(), map.getColumn());
        boolean checker = checkIfCoordsEmpty(map, coordinates);
        while(!checker) {
            coordinates = generateRandCoordinates(map.getRow(), map.getColumn());
            checker = checkIfCoordsEmpty(map, coordinates);
        }
        map.add(coordinates, new Grass());
    }

}
