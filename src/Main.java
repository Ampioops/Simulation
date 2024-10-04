import Simulation.*;
import Entity.*;



//Задаем размер поля
//Спрашиваем кол-во Сущностей(всех)
//Запускаем симуляцию startSimulation
//Сделаю 2 хищника/ 4 траводных/ 3 дерева/ 4 камня/ 4 травы
public class Main {
    public static void main(String[] args) {
        Simulation s = new Simulation();
        s.setSizeOfSimulation(10,10);
        Herbivore e2 = new Herbivore(new Coordinates(5,5),2, 25);
        Predator e3 = new Predator(new Coordinates(3,3), 4, 10, 25);
        Tree e4 = new Tree(new Coordinates(1, 3));
        Tree e5 = new Tree(new Coordinates(2, 3));
        Rock e6 = new Rock(new Coordinates(1, 7));
        Grass e7 = new Grass(new Coordinates(1, 2));
        Grass e8 = new Grass(new Coordinates(1, 3));
        Grass e9 = new Grass(new Coordinates(1, 4));



        Simulation.setEntity(e2, e2.getCoordinates());
        Simulation.setEntity(e3, e3.getCoordinates());
        Simulation.setEntity(e4, e4.getCoordinates());
        Simulation.setEntity(e5, e5.getCoordinates());
        Simulation.setEntity(e6, e6.getCoordinates());
        Simulation.setEntity(e7, e7.getCoordinates());
        Simulation.setEntity(e8, e8.getCoordinates());
        Simulation.setEntity(e9, e9.getCoordinates());


        s.startSimulation();



    }
}