package Simulation;

import Entity.Coordinates;
import Entity.Entity;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class Simulation implements Action {
    Integer counter = 0;
    static Integer height;
    static Integer width;
    Renderer renderer;
    static private Map<Coordinates, Entity> entities = new HashMap<>();

    public void setEntity(Entity entity, Coordinates coordinates){
        entity.setCoordinates(coordinates);
        entities.put(coordinates, entity);
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
    public void initAction() {

    }

    @Override
    public void turnAction() {

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
