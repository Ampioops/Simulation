package Entity;

import Simulation.MapClass;

public abstract class Creature extends Entity {
    private Integer speed;
    private Integer HP;
    private boolean canCreatureMakeMove;

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
    public int getHP(){
        return HP;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setHP(Integer HP) {
        this.HP = HP;
    }

    public abstract void makeMove(Coordinates coordinates, MapClass map);

}
