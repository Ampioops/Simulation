package Simulation;

import Entity.*;

import java.util.HashMap;
import java.util.Map;

import static Simulation.Emojis.mapEmojis;

public class Renderer {

    public void render(Integer row, Integer column, Map<Coordinates, Entity> entities) {
        for (int i = 0; i < row; i++) {//строки
            StringBuilder line = new StringBuilder();
            for (int j = 0; j < column; j++) {
                if (entities.get(new Coordinates(i, j)) != null) {
                    line.append(String.format(" %3s", mapEmojis.get(getTypeEntity(entities.get(new Coordinates(i, j))))));
                } else {
                    if (j != column) {
                        line.append(String.format("%3s ",mapEmojis.get("EmptyWay")));
                    } else {
                        line.append(String.format("%3s",mapEmojis.get("EmptyWay")));
                    }
                }
            }
            System.out.println(line);
        }
    }

    public String getTypeEntity(Entity entity) {
        if (entity instanceof Predator) {
            return "Predator";
        } else if (entity instanceof Herbivore) {
            return "Herbivore";
        } else if (entity instanceof Rock) {
            return "Rock";
        } else if (entity instanceof Tree) {
            return "Tree";
        } else if (entity instanceof Grass) {
            return "Grass";
        }else {
            return "unknown";
        }
    }
}
