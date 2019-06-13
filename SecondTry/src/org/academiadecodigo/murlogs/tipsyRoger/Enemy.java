package org.academiadecodigo.murlogs.tipsyRoger;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Enemy extends Character {

    private Picture enemy;
    private int iterator;

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
    public boolean canAttack() {
        double randomNumber = Math.random();
        if (randomNumber < 0.005){
            return true;
        }
        return false;
    }

    public abstract Puke attack(Directions directions);
}

