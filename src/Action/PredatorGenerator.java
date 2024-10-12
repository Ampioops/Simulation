package Action;

import Entity.Coordinates;
import Entity.Herbivore;
import Simulation.MapClass;

public class PredatorGenerator extends CreatureGenerator{
    @Override
    public void create(MapClass map) {
        double spawnRate = (double) (map.getColumn() * map.getRow()) / 100;
        int rate = map.countOfExactEntity(Herbivore.class);

        for (rate = 0; rate < spawnRate;) {
            Coordinates coordinates = generateRandCoordinates(map.getRow(), map.getColumn());
            int speed = (int)(Math.random()*5) + 1;
            int HP = (int)(Math.random()*11) + 10;
            int ATK = (int)(Math.random()*1) + 1;

            if(checkIfCoordsEmpty(map, coordinates)) {
                map.add(coordinates, new Herbivore(speed, HP));
                rate++;
            }

        }
    }

    public boolean checkIfCoordsEmpty(MapClass map, Coordinates coords) {
        return !map.contains(coords);
    }
}
