package org.academiadecodigo.murlogs.tipsyRoger.GameObjects.Characters.Enemy;


import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Barman extends Enemy {

    Rectangle barmanRectangle;


    public Barman(Rectangle rectangle) {
        this.barmanRectangle = rectangle;

    }

    @Override
    public void move() {
        super.move();
    }

    @Override
    public void attack() {
        super.attack();
    }

    @Override
    public void setDead() {
        super.setDead();
    }

    @Override
    public boolean isDead() {
        return super.isDead();
    }

    @Override
    public void draw() {
        barmanRectangle.draw();
    }

    @Override
    public int y() {
        return (int) barmanRectangle.getY();
    }

    @Override
    public int x() {
        return (int) barmanRectangle.getX();
    }

    @Override
    public int yToHeight() {
        return (int) (barmanRectangle.getX() + barmanRectangle.getHeight());
    }

    @Override
    public int xToWidth() {
        return (int) (barmanRectangle.getY() + barmanRectangle.getWidth());
    }
}

