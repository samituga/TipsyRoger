package org.academiadecodigo.murlogs.tipsyRoger;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Enemy extends Character {

    private Picture enemy;

    Enemy(Picture enemy) {
        super(enemy);
        this.enemy = super.picture;
    }

    public void hitten() {
        enemy.delete();
        this.dead = true;
    }

    @Override
    public void move() {

    }

    public Puke attack(Directions directions) {
        return null;
    }
}

