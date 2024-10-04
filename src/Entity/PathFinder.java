package Entity;

import Simulation.Simulation;

import java.util.*;
import java.util.stream.Stream;

public class PathFinder {

    private static final Map<Coordinates, Entity> entities = Simulation.getEntities();
    private static final Integer height = Simulation.getHeight();
    private static final Integer width = Simulation.getWidth();
    private static final Herbivore herbivoreObj = new Herbivore(new Coordinates(0, 0), 0, 0);
    private static final Predator predatorObj = new Predator(new Coordinates(0, 0), 0, 0, 0);

    public static List<Coordinates> calculatePath(Coordinates startPoint, Class<?> searcherClass) {

        Set<Coordinates> visited = new HashSet<>();
        Queue<Coordinates> queue = new ArrayDeque<>();

        Map<Coordinates, Coordinates> parent = new HashMap<>();

        queue.add(startPoint);
        visited.add(startPoint);

        while (!queue.isEmpty()) {
            Coordinates node = queue.poll();

            if (searcherClass.isInstance(herbivoreObj) && (entities.get(node) instanceof Grass)) {

                return constructPath(startPoint, node, parent);

            } else if (searcherClass.isInstance(predatorObj) && (entities.get(node) instanceof Herbivore)) {

                return constructPath(startPoint, node, parent);

            }

            for (Coordinates neighbour : getNeighbours(node, searcherClass)) { //ПЕРЕБИРАЕМ СОСЕДЕЙ УЗЛА
                if (!visited.contains(neighbour)) { // ЕСЛИ НЕТ В УЖЕ ПОСЕЩЕННЫХ - ДОБАВЛЯЕМ ВСЕ И ЗАПОМИНАЕМ ОТЦА
                    visited.add(neighbour);
                    queue.add(neighbour);
                    parent.put(neighbour, node);
                }
            }
        }
        return new ArrayList<>();
    }

    public static List<Coordinates> getNeighbours(Coordinates node, Class<?> searcherClass) {

        List<Coordinates> neighbours = Stream.of(-1, 1, 0)// ТУТ ПРОСТО БЕРЕМ СОСЕДЕЙ УЗЛА, ПРИЧЕМ КАМНИ И ВСЯ ТАКАЯ ПОЕБЕНЬ НЕ ВХОДИТ
                .flatMap(i -> Stream.of(-1, 1, 0)
                        .map(j -> new Coordinates(node.row + i, node.column + j)))
                .filter(coord -> coord.row >= 0 && coord.column >= 0)
                .filter(coord -> coord.row <= height && coord.column <= width)
                .filter(coord -> !(entities.get(coord) instanceof Rock || entities.get(coord) instanceof Tree || entities.get(coord) instanceof Predator))
                .toList();

        if (searcherClass.isInstance(herbivoreObj)) {
            neighbours = neighbours.stream()
                    .filter(coord -> !(entities.get(coord) instanceof Herbivore))
                    .toList();
        }else if (searcherClass.isInstance(predatorObj)) {
            neighbours = neighbours.stream()
                    .filter(coord -> !(entities.get(coord) instanceof Grass))
                    .toList();
        }

        if (neighbours.isEmpty()) {
            return new ArrayList<>();
        } else return neighbours;
    }


    //ТУТ САМОЕ СЛОЖНОЕ
    //КРЧ КОГДА МЫ ДОШЛИ ДО ТАРГЕТА - ВОССТАНАВЛИВАЕМ ПУТЬ В ОБРАТНОМ ПОРЯДКЕ =)
    private static List<Coordinates> constructPath(Coordinates startPoint, Coordinates target, Map<Coordinates, Coordinates> parent) {
        List<Coordinates> path = new ArrayList<>();
        for (Coordinates node = target; node != null; node = parent.get(node)) {// БЕРЕМ ОТЦА ОТЦА И БЭМ БЭМ
            path.add(node);
        }
        Collections.reverse(path);  // Путь восстанавливается в обратном порядке
        return path;
    }

}
