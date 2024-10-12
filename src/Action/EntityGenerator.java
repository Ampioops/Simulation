package Action;

import Simulation.MapClass;

public abstract class EntityGenerator extends Generator {
    abstract public void create(MapClass map);
}
