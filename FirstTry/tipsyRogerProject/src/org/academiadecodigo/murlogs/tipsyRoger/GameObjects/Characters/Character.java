package org.academiadecodigo.murlogs.tipsyRoger.GameObjects.Characters;

import org.academiadecodigo.murlogs.tipsyRoger.Colidable;

public abstract class Character extends Colidable {

    private String name;
    private boolean dead;
    // private Position pos;

    public abstract void move();
    public abstract void attack();

    public void setDead() {
        this.dead = true;
    }

    public boolean isDead() {
        return dead;
    }

}
