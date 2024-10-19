package Action;

import Entity.Coordinates;
import Entity.Herbivore;
import Entity.Predator;
import Simulation.MapClass;

public class PredatorGenerator extends CreatureGenerator{
    @Override
    public void create(MapClass map) {
        double spawnRate = (double) (map.getColumn() * map.getRow()) / 100;

        for (int rate = map.countOfExactEntity(Predator.class); rate < spawnRate;) {
            Coordinates coordinates = generateRandCoordinates(map.getRow(), map.getColumn());
            int speed = (int)(Math.random()*5) + 1;
            int HP = (int)(Math.random()*11) + 10;
            int ATK = (int)(Math.random()*6) + 10;

            if(checkIfCoordsEmpty(map, coordinates)) {
                map.add(coordinates, new Predator(speed, HP, ATK));
                rate++;
            }

        }
    }

    @Override
    public void createOneInstance(MapClass map) {
        Coordinates coordinates = generateRandCoordinates(map.getRow(), map.getColumn());
        int speed = (int)(Math.random()*5) + 1;
        int HP = (int)(Math.random()*11) + 10;
        int ATK = (int)(Math.random()*6) + 10;
        boolean checker = checkIfCoordsEmpty(map, coordinates);
        while(!checker) {
            coordinates = generateRandCoordinates(map.getRow(), map.getColumn());
            checker = checkIfCoordsEmpty(map, coordinates);
        }
        map.add(coordinates, new Predator(speed, HP, ATK));
    }

}
