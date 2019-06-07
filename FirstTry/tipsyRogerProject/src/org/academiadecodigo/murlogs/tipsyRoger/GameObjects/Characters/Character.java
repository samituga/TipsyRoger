package org.academiadecodigo.murlogs.tipsyRoger.GameObjects.Characters;

public abstract class Character {

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
