package org.academiadecodigo.murlogs.tipsyRoger;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public abstract class Enemy extends Character {

    private Rectangle enemy;

    Enemy(Rectangle enemy){
        this.enemy = enemy;
    }

    public void hitten() {
        enemy.delete();
        this.dead = true;
    }

    @Override
    public void move() {

    }

    @Override
    public void draw() {
        enemy.setColor(Color.GREEN);
        enemy.fill();
    }

    @Override
    public int x() {
        return enemy.getX();
    }

    @Override
    public int y() {
        return enemy.getY();
    }

    @Override
    public int xToWidth() {
        return x() + enemy.getWidth();
    }

    @Override
    public int yToHeight() {
        return y() + enemy.getHeight();
    }

    @Override
    public Puke attack() {
        return null;
    }
}

