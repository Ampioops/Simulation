package Simulation;

import Action.*;
import Entity.*;

import java.util.HashSet;
import java.util.Set;

public class Simulation{

    CreatureGenerator generatorHerbivore = new HerbivoreGenerator();
    CreatureGenerator generatorPredator = new PredatorGenerator();
    GrassGenerator generatorGrass = new GrassGenerator();
    EntityGenerator generatorTrash = new TrashGenerator();
    boolean entitiesGenerated = false;
    boolean isRunning = false;
    boolean isPaused = false;
    Integer turnCounter = 0;
    Renderer renderer= new Renderer();
    public static MapClass map = new MapClass(10,10);


    public void changeSizeOfSimulation(Integer row, Integer col){
        map.setRow(row);
        map.setColumn(col);
    }

    public void startSimulation() throws InterruptedException {

        // Генерируются рандомно объекты симуляции -- Action - generate entities
        // Расставляются созданные объекты -- Action - place every entity
        isRunning = true;
        generateEveryEntity();
        entitiesGenerated = true;
        renderMap();

        while (isRunning) {
            synchronized (Thread.currentThread()){
                while (isPaused){
                    Thread.currentThread().wait();
                }
            }

            nextTurn();
            renderMap();

            Thread.sleep(1500);
        }
        System.out.println("Симуляция завершена.");

    }

    public void nextTurn() {
        if (entitiesGenerated) {
            Set<Coordinates> coordSet = new HashSet<>(map.getCoordinatesSet());

            for (Coordinates coordinates : coordSet) {
                if (map.getEntity(coordinates) instanceof Creature && ((Creature) map.getEntity(coordinates)).canMove()) {
                    ((Creature) map.getEntity(coordinates)).makeMove(coordinates, map);
                }
            }

            Set<Coordinates> resetter = new HashSet<>(map.getCoordinatesSet());

            for (Coordinates coordinates : resetter) {
                if (map.getEntity(coordinates) instanceof Creature) {
                    ((Creature) map.getEntity(coordinates)).resetAbilityMakeMove();
                }
            }

            turnCounter++;
        }
    }

    public void pauseSimulation() {
        isPaused = true;
    }

    public void resumeSimulation() {
        isPaused = false;
    }

    public void stopSimulation() {
        isRunning = false;
    }

    private void generateEveryEntity(){
        generatorGrass.create(map);
        generatorHerbivore.create(map);
        generatorPredator.create(map);
        generatorTrash.create(map);
    }

    private void renderMap(){
        renderer.render(map);
    }

    public void refreshSimulation(){
        map = new MapClass(map.getRow(),map.getColumn());
        entitiesGenerated = false;
        isRunning = false;
        isPaused = false;
        turnCounter = 0;
    }

}
