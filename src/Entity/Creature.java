package Entity;

import Simulation.MapClass;

public abstract class Creature extends Entity {
    Integer speed;
    Integer HP;
    boolean canCreatureMakeMove;

    public Creature(Integer speed, Integer HP) {
        this.speed = speed;
        this.HP = HP;
        this.canCreatureMakeMove = true;
    }

    public void moved(){
        this.canCreatureMakeMove = false;
    }

    public boolean canMove(){
        return this.canCreatureMakeMove;
    }

    public void resetAbilityMakeMove(){
        this.canCreatureMakeMove = true;
    }

    public abstract void makeMove(Coordinates coordinates, MapClass map);

}
