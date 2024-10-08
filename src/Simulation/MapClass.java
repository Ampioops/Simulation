package Simulation;

import Entity.*;

import java.util.*;

public class MapClass {

    private Map<Coordinates, Entity> map;
    final Integer row;
    final Integer column;

    public MapClass(Integer width, Integer height) {
        this.column = width;
        this.row = height;
        map = new HashMap<>();
    }

    public boolean contains(Coordinates coordinates) {
        return map.containsKey(coordinates);
    }

    public void add(Coordinates coordinates, Entity entity) {
        map.put(coordinates, entity);
    }

    public void updateEntity(Coordinates coordinates, Entity entity) {
        add(coordinates, entity);
    }

    public Coordinates del(Coordinates coordinates) {
        map.remove(coordinates);
        return coordinates;
    }

    public Entity getEntity(Coordinates coordinates) {
        return map.get(coordinates);
    }

    public Collection<Entity> getEntities() {

        return map.values();
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public Set<Coordinates> getCoordinatesSet() {
        return map.keySet();
    }

    public boolean ifExists(Coordinates coordinates) {
        return map.containsKey(coordinates);
    }
}
