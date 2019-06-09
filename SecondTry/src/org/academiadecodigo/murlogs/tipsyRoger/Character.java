package org.academiadecodigo.murlogs.tipsyRoger;


public abstract class Character extends Colidable {
    protected boolean dead;

    public abstract void move();
    public abstract Puke attack(Directions direction);


}
