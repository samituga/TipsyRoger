package org.academiadecodigo.murlogs.tipsyRoger.GameObjects.Characters;

import org.academiadecodigo.simplegraphics.graphics.Movable;


public abstract class Character implements Movable {

    private String name;
    private boolean dead;
    private Position pos;

    public abstract void move();
    public abstract void attack();

    public void setDead() {
        this.dead = true;
    }

    public boolean isDead() {
        return dead;
    }

}
