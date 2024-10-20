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

        Simulation s = new Simulation();

        while (idMenu != 6) {
            System.out.println("============ Меню симуляции ============");
            System.out.println("1 - Симулировать игровой Мир - сделать один ход");
            System.out.println("2 - Запустить бесконечную симуляцию игрового Мира ");
            System.out.println("3 - Изменить размер Мира симуляции (default = 15,15)");
            System.out.println("4 - Начать игру сначала");
            System.out.println("5 - Конец  Игры");
            System.out.println("=======================================");

            idMenu = sc.nextInt();

            switch (idMenu) {
                case 1:
                    System.out.println("Симуляция одного хода:");
                    s.nextTurn();

                    break;
                case 2:
                    System.out.println("Запускаю бесконечную симуляцию игрового мира:");

                    Thread simulationThread = new Thread(() -> {
                        try {
                            s.startSimulation();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    });
                    simulationThread.start();

                    while (true) {
                        System.out.println("Введите 'p' чтобы остановить симуляцию, 'r' чтобы продолжить, и 's', чтобы завершить:");
                        String command = sc.nextLine();

                        if (command.equalsIgnoreCase("p")) {
                            s.pauseSimulation(); // Поставить симуляцию на паузу
                        } else if (command.equalsIgnoreCase("r")) {
                            s.resumeSimulation(); // Снять симуляцию с паузы
                            synchronized (simulationThread) {
                                simulationThread.notify(); // Пробудить поток симуляции
                            }
                        }else if (command.equalsIgnoreCase("s")) {
                            s.stopSimulation();
                            synchronized (simulationThread) {
                                simulationThread.notify();
                            }
                            break;
                        }
                    }
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
                    s.refreshSimulation();
                    System.out.println("Мир обновлен");
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