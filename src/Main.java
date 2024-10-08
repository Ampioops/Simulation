import Simulation.*;
import Entity.*;



//Задаем размер поля
//Спрашиваем кол-во Сущностей(всех)
//Запускаем симуляцию startSimulation
//Сделаю 2 хищника/ 4 траводных/ 3 дерева/ 4 камня/ 4 травы
public class Main {
    public static void main(String[] args) {
        Simulation s = new Simulation();
        Herbivore e2 = new Herbivore(2, 25);
        Predator e3 = new Predator(4, 10, 25);
        Tree e4 = new Tree();
        Tree e5 = new Tree();
        Rock e6 = new Rock();
        Grass e7 = new Grass();
        Grass e8 = new Grass();
        Grass e9 = new Grass();

        s.map.add(new Coordinates(5,5), e2);
        s.map.add(new Coordinates(3,3), e3);
        s.map.add(new Coordinates(1, 3), e4);
        s.map.add(new Coordinates(2, 3), e5);
        s.map.add(new Coordinates(1, 7), e6);
        s.map.add(new Coordinates(6,6), e7);
        s.map.add(new Coordinates(1,3), e8);
        s.map.add(new Coordinates(1,4), e9);

        s.startSimulation();



    }
}