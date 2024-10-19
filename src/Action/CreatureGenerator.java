package Action;

import Simulation.MapClass;

public abstract class CreatureGenerator extends EntityGenerator {
    abstract void createOneInstance(MapClass map);
}
