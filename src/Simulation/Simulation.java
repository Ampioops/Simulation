package Simulation;

import Entity.Coordinates;
import Entity.Entity;

import java.util.HashMap;
import java.util.Map;

public class Simulation implements Action {
    Integer counter = 0;
    static Integer height;
    static Integer width;
    Renderer renderer;
    static private Map<Coordinates, Entity> entities = new HashMap<>();

    public static void setEntity(Entity entity, Coordinates coordinates){
        entity.setCoordinates(coordinates);
        entities.put(coordinates, entity);
    }

    public static void deleteEntity(Entity entity){
        entities.remove(entity.getCoordinates());
    }

    public void setSizeOfSimulation(Integer height, Integer width){
        Simulation.height = height;
        Simulation.width = width;
    }

    public void startSimulation(){
        renderer = new Renderer();
        renderer.render(height, width, entities);

    }

    public void nextTurn(){

    }

    public void pauseSimulation(){

    }

    @Override
    public void initAction() { //действия, совершаемые перед стартом симуляции. Пример - расставить объекты и существ на карте

    }

    @Override
    public void turnAction() { //действия, совершаемые каждый ход. Примеры - передвижение существ, добавить травы или травоядных, если их осталось слишком мало

    }

    public static Integer getWidth() {
        return width;
    }
    public static Integer getHeight() {
        return height;
    }

    public static Map<Coordinates, Entity> getEntities() {
        return entities;
    }
}
