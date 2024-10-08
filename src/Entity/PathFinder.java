package Entity;

import Simulation.*;

import java.util.*;
import java.util.stream.Stream;

public class PathFinder {

    private static final Herbivore herbivoreObj = new Herbivore(0, 0);
    private static final Predator predatorObj = new Predator( 0, 0, 0);

    public static List<Coordinates> calculatePath(MapClass map, Coordinates startPoint, Class<?> searcherClass) {

        Set<Coordinates> visited = new HashSet<>();
        Queue<Coordinates> queue = new ArrayDeque<>();

        Map<Coordinates, Coordinates> parent = new HashMap<>();

        queue.add(startPoint);
        visited.add(startPoint);

        while (!queue.isEmpty()) {
            Coordinates node = queue.poll();

            if (searcherClass.isInstance(herbivoreObj) && (map.getEntity(node) instanceof Grass)) {

                return constructPath(startPoint, node, parent);

            } else if (searcherClass.isInstance(predatorObj) && (map.getEntity(node) instanceof Herbivore)) {

                return constructPath(startPoint, node, parent);

            }

            for (Coordinates neighbour : getNeighbours(node, searcherClass, map)) { //ПЕРЕБИРАЕМ СОСЕДЕЙ УЗЛА
                if (!visited.contains(neighbour)) { // ЕСЛИ НЕТ В УЖЕ ПОСЕЩЕННЫХ - ДОБАВЛЯЕМ ВСЕ И ЗАПОМИНАЕМ ОТЦА
                    visited.add(neighbour);
                    queue.add(neighbour);
                    parent.put(neighbour, node);
                }
            }
        }
        return new ArrayList<>();
    }

    public static List<Coordinates> getNeighbours(Coordinates node, Class<?> searcherClass, MapClass map) {

        List<Coordinates> neighbours = Stream.of(-1, 1, 0)// ТУТ ПРОСТО БЕРЕМ СОСЕДЕЙ УЗЛА, ПРИЧЕМ КАМНИ И ВСЯ ТАКАЯ ПОЕБЕНЬ НЕ ВХОДИТ
                .flatMap(i -> Stream.of(-1, 1, 0)
                        .map(j -> new Coordinates(node.row + i, node.column + j)))
                .filter(coord -> coord.row >= 0 && coord.column >= 0)
                .filter(coord -> coord.row <= map.getColumn() && coord.column <= map.getRow())
                .filter(coord -> !(map.getEntity(coord) instanceof Rock || map.getEntity(coord) instanceof Tree || map.getEntity(coord) instanceof Predator))
                .toList();

        if (searcherClass.isInstance(herbivoreObj)) {
            neighbours = neighbours.stream()
                    .filter(coord -> !(map.getEntity(coord) instanceof Herbivore))
                    .toList();
        }else if (searcherClass.isInstance(predatorObj)) {
            neighbours = neighbours.stream()
                    .filter(coord -> !(map.getEntity(coord) instanceof Grass))
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
