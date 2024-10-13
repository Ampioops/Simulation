package Simulation;

import Entity.Coordinates;
import Entity.Entity;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapClass {

    private Map<Coordinates, Entity> map;
    Integer row;
    Integer column;

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

    public Coordinates delete(Coordinates coordinates) {
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

    public void setRow(Integer row) {
        this.row = row;
    }

    public void setColumn(Integer column) {
        this.column = column;
    }

    public int countOfExactEntity(Class<?> entityClass) {
        int count = 0;
        for (Object obj : map.values()) {
            if (entityClass.isInstance(obj)) {
                count++;
            }
        }
        return count;
    }
}
