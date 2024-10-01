package Entity;

import java.util.Map;

public abstract class Creature extends Entity {
    Integer speed;
    Integer HP;

    public Creature(Coordinates coordinates, Integer speed, Integer HP) {
        super(coordinates);
        this.speed = speed;
        this.HP = HP;
    }

    abstract void makeMove(Map<Coordinates, Entity> entities);

}
