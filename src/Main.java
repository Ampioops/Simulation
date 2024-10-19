import Entity.*;
import Simulation.Simulation;

import java.util.Scanner;


//Задаем размер поля
//Спрашиваем кол-во Сущностей(всех)
//Запускаем симуляцию startSimulation
//Сделаю 2 хищника/ 4 траводных/ 3 дерева/ 4 камня/ 4 травы
public class Main {
    public static void main(String[] args) throws InterruptedException {

        Scanner sc = new Scanner(System.in);

        int idMenu = -1;

        Simulation s = new Simulation(10, 10);

        while (idMenu != 6) {
            System.out.println("============ Меню симуляции ============");
            System.out.println("1 - Симулировать игровой Мир - сделать один ход");
            System.out.println("2 - Запустить бесконечную симуляцию игрового Мира ");
            System.out.println("3 - Изменить размер Мира симуляции (default = 10,10)");
            System.out.println("4 - Начать игру с начала");
            System.out.println("5 - Конец  Игры");
            System.out.println("=======================================");

            idMenu = sc.nextInt();

            switch (idMenu) {
                case 1:
                    System.out.println("Симуляция одного хода:");
                    s.nextTurn();

                    break;
                case 2:
//                    System.out.println("Запускаю бесконечную симуляцию игрового мира:");
//                    System.out.println("Введите 'pause' чтобы остановить симуляцию или 'resume' чтобы продолжить:");
//
//                    Thread simulationThread = new Thread(() -> {
//                        try {
//                            s.startSimulation();
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    });
//                    simulationThread.start();

                    break;
                case 3:
                    System.out.println("Введите высоту Мира симуляции:");
                    Integer rows = sc.nextInt();

                    System.out.println("Введите ширину Мира симуляции:");
                    Integer cols = sc.nextInt();

                    s.changeSizeOfSimulation(rows, cols);
                    System.out.printf("Размер установлен на %s %s \n", rows, cols);

                    break;
                case 4:
                    break;
                case 5:
                    idMenu = 6;
                    break;
                default:
                    System.out.println("Ошибка ввода - повторите заново");
                    break;

            }
        }
    }
}