package Action;

import Entity.Coordinates;
import Entity.Herbivore;
import Entity.Predator;
import Simulation.MapClass;

public class HerbivoreGenerator extends CreatureGenerator{

    @Override
    public void create(MapClass map) {
        int spawnRate = (int) Math.ceil((double) ((map.getColumn() * map.getRow()) * 3) / 100);

        for (int rate = map.countOfExactEntity(Herbivore.class); rate < spawnRate;) {
            Coordinates coordinates = generateRandCoordinates(map.getRow(), map.getColumn());
            int speed = (int)(Math.random()*4) + 1;
            int HP = (int)(Math.random()*21) + 10;

            if(checkIfCoordsEmpty(map, coordinates)) {
                map.add(coordinates, new Herbivore(speed, HP));
                rate++;
            }
        }
    }

    @Override
    public void createOneInstance(MapClass map) {
        Coordinates coordinates = generateRandCoordinates(map.getRow(), map.getColumn());
        int speed = (int)(Math.random()*4) + 1;
        int HP = (int)(Math.random()*21) + 10;
        boolean checker = checkIfCoordsEmpty(map, coordinates);
        while(!checker) {
            coordinates = generateRandCoordinates(map.getRow(), map.getColumn());
            checker = checkIfCoordsEmpty(map, coordinates);
        }
        map.add(coordinates, new Herbivore(speed, HP));
    }
}
