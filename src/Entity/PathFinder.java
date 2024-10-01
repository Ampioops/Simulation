package Entity;

import Simulation.Simulation;

import java.util.*;
import java.util.stream.Stream;

public class PathFinder {

    private static final Map<Coordinates, Entity> entities = Simulation.getEntities();
    private final List<Coordinates> foundPath = new ArrayList<>();
    private static final Integer height = Simulation.getHeight();
    private static final Integer width = Simulation.getWidth();

     public static List<Coordinates> calculatePath(Coordinates startPoint, Class<?> targetClass) {

        Set<Coordinates> visited = new HashSet<>();
        Queue<Coordinates> queue = new ArrayDeque<>();

        Map<Coordinates, Coordinates> parent = new HashMap<>();

        queue.add(startPoint);
        visited.add(startPoint);

         while (!queue.isEmpty()) {
            Coordinates node = queue.poll();

            if (targetClass.isInstance(entities.get(node))) {

                return constructPath(startPoint, node, parent);           //ПЕРЕДЕЛАТЬ - ВИДИТ ТАРГЕТ КЛАСС КАК ХЕБИВОР И СРАЗУ ВЫХОДИТ ИЗ ЦИКЛА

            }

            for (Coordinates neighbour : getNeighbours(node)) { //ПЕРЕБИРАЕМ СОСЕДЕЙ УЗЛА
                if (!visited.contains(neighbour)) { // ЕСЛИ НЕТ В УЖЕ ПОСЕЩЕННЫХ - ДОБАВЛЯЕМ ВСЕ И ЗАПОМИНАЕМ ОТЦА
                    visited.add(neighbour);
                    queue.add(neighbour);
                    parent.put(neighbour, node);
                }
            }
        }
         return new ArrayList<>();
     }

    public static List<Coordinates> getNeighbours(Coordinates node) {
        List<Coordinates> neibhours = Stream.of(-1, 1)// ТУТ ПРОСТО БЕРЕМ СОСЕДЕЙ УЗЛА, ПРИЧЕМ КАМНИ И ВСЯ ТАКАЯ ПОЕБЕНЬ НЕ ВХОДИТ
                .flatMap(i -> Stream.of(-1, 1)
                        .map(j -> new Coordinates(node.row + i, node.column + j)))
                .filter(coord -> coord.row >= 0 && coord.column >= 0)
                .filter(coord -> coord.row <= height && coord.column <= width)
                .filter(coord -> !(entities.get(coord) instanceof Rock || entities.get(coord) instanceof Tree))
                .toList();

        if (neibhours.isEmpty()) {
            return new ArrayList<>();
        } else return neibhours;
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
