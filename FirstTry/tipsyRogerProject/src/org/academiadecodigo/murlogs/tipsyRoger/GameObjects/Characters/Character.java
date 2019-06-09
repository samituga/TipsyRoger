package org.academiadecodigo.murlogs.tipsyRoger.GameObjects.Characters;

import org.academiadecodigo.murlogs.tipsyRoger.Colidable;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;


public abstract class Character extends Colidable {

    private boolean dead;

    public abstract void move() throws InterruptedException;
    public abstract void attack();

    public void setDead() {
        this.dead = true;
    }

    public boolean isDead() {
        return dead;
    }

}
