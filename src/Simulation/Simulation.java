package Simulation;

import Action.*;
import Entity.*;

import java.util.HashSet;
import java.util.Set;

public class Simulation{
    Integer turnCounter = 0;
    Renderer renderer= new Renderer();
    public MapClass map;


    public Simulation(Integer row, Integer col) {
        map = new MapClass(col, row);
    }

    public void changeSizeOfSimulation(Integer row, Integer col){
        map.setRow(row);
        map.setColumn(col);
    }

    public void startSimulation() {
        renderer.render(map);
        System.out.println();
        // Генерируются рандомно объекты симуляции -- Action - generate entities
        EntityGenerator generator = new HerbivoreGenerator();
        generator.create(map);
        renderer.render(map);

        nextTurn();
        System.out.println();
        renderer.render(map);

        // Расставляются созданные объекты -- Action - place every entity

        // Запускается бесконечный цикл -- while .. nextTurn()

        // Проверка количества элементов симуляции -- Action - checkIfWeNeedMoreEntities
        // Если не хватает -- Action - addNewEntities

    }

    public void nextTurn() {

        Set<Coordinates> coordSet = new HashSet<>(map.getCoordinatesSet());

        for(Coordinates coordinates : coordSet) {
            if (map.getEntity(coordinates) instanceof Creature && ((Creature) map.getEntity(coordinates)).canMove()) {
                ((Creature) map.getEntity(coordinates)).makeMove(coordinates,map);
            }
        }

        Set<Coordinates> resetter = new HashSet<>(map.getCoordinatesSet());

        for(Coordinates coordinates : resetter) {
            if (map.getEntity(coordinates) instanceof Creature) {
                ((Creature) map.getEntity(coordinates)).resetAbilityMakeMove();
            }
        }

        turnCounter++;
    }

    public void pauseSimulation() {

    }

}
