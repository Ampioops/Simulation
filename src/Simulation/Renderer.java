package Simulation;

import Entity.*;

import java.util.HashMap;
import java.util.Map;

import static Simulation.Emojis.mapEmojis;

public class Renderer {

    public void render(Integer N, Integer M, Map<Coordinates, Entity> entities) {
        for (int i = 0; i < N; i++) {//строки
            StringBuilder line = new StringBuilder();
            for (int j = 0; j < M; j++) {
                if (entities.get(new Coordinates(i, j)) != null) {
                    line.append(String.format(" %3s", mapEmojis.get(getTypeEntity(entities.get(new Coordinates(i, j))))));
                } else {
                    if (j != M) {
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
